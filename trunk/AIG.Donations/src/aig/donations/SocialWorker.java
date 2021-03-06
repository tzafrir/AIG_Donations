package aig.donations;

import java.util.Date;

import aig.donations.exceptions.CategoryNotFoundException;
import aig.donations.exceptions.EmptyWaitingListException;
import aig.donations.exceptions.IllegalItemStatusTransitionException;
import aig.donations.exceptions.IllegalProjectDescriptionException;
import aig.donations.exceptions.IllegalProjectDescriptionLengthException;
import aig.donations.exceptions.IllegalProjectEventTimeException;
import aig.donations.exceptions.IllegalProjectLocationException;
import aig.donations.exceptions.IllegalProjectLocationLengthException;
import aig.donations.exceptions.IllegalProjectNameException;
import aig.donations.exceptions.IllegalProjectNameLengthException;
import aig.donations.exceptions.IllegalUserNameException;
import aig.donations.exceptions.IllegalUserNameLengthException;
import aig.donations.exceptions.IllegalUserRoleException;
import aig.donations.exceptions.IllegalUserUsernameException;
import aig.donations.exceptions.IllegalUserUsernameLengthException;
import aig.donations.exceptions.IncorrectSocialWorkerException;
import aig.donations.exceptions.ItemNotFoundException;
import aig.donations.exceptions.ItemNotPendingException;
import aig.donations.exceptions.ProjectAlreadyClosedException;
import aig.donations.exceptions.ProjectClosedException;
import aig.donations.exceptions.ProjectNotFoundException;

public class SocialWorker extends User {
  protected CategoryDatabaseGateway categoryDBGateway = new CategoryDatabaseGatewayImpl();
  protected ProjectDatabaseGateway projectDBGateway = new ProjectDatabaseGatewayImpl();
  protected ItemDatabaseGateway itemDBGateway = new ItemDatabaseGatewayImpl();

  SocialWorker(User user) throws IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    super(user.getUsername(), user.getRole(), user.getName());
  }

  public long createProject(String name, String description, String location, Date eventTime)
      throws IllegalProjectNameLengthException, IllegalProjectNameException,
      IllegalProjectDescriptionLengthException, IllegalProjectDescriptionException,
      IllegalProjectLocationLengthException, IllegalProjectLocationException,
      IllegalProjectEventTimeException {
    checker.checkProjectName(name);
    checker.checkProjectDescription(description);
    checker.checkProjectLocation(location);
    checker.checkProjectEventTime(eventTime);
    return projectDBGateway.addToDB(name, description, location, eventTime, getUsername());
  }

  public void closeProject(long projectId) throws ProjectNotFoundException,
      ProjectAlreadyClosedException, IncorrectSocialWorkerException {
    Project project = projectDBGateway.retrieveProject(projectId);

    checker.checkThatProjectIsOurs(project, getUsername(), getRole());

    if (project.isClosed()) {
      throw new ProjectAlreadyClosedException("can't close a project that is already closed");
    }

    project.setEventTime(new Date());
  }

  public void renameProject(long projectId, String newName) throws ProjectNotFoundException,
      IncorrectSocialWorkerException, IllegalProjectNameLengthException,
      IllegalProjectNameException {
    checker.checkProjectName(newName);

    Project project = projectDBGateway.retrieveProject(projectId);

    checker.checkThatProjectIsOurs(project, getUsername(), getRole());

    project.setName(newName);
  }

  public void changeProjectDescription(long projectId, String newDescription)
      throws ProjectNotFoundException, IncorrectSocialWorkerException,
      IllegalProjectDescriptionLengthException, IllegalProjectDescriptionException {
    checker.checkProjectDescription(newDescription);

    Project project = projectDBGateway.retrieveProject(projectId);

    checker.checkThatProjectIsOurs(project, getUsername(), getRole());

    project.setDescription(newDescription);
  }

  public void changeProjectLocation(long projectId, String newLocation)
      throws ProjectNotFoundException, IllegalProjectLocationLengthException,
      IllegalProjectLocationException {
    checker.checkProjectLocation(newLocation);

    projectDBGateway.retrieveProject(projectId).setLocation(newLocation);
  }

  public void changeProjectTime(long projectId, Date newEventTime) throws ProjectNotFoundException,
      IncorrectSocialWorkerException, IllegalProjectEventTimeException {
    checker.checkProjectEventTime(newEventTime);

    Project project = projectDBGateway.retrieveProject(projectId);

    checker.checkThatProjectIsOurs(project, getUsername(), getRole());

    project.setEventTime(newEventTime);
  }

  public void addCategoryToProject(long projectId, long categoryId)
      throws ProjectNotFoundException, CategoryNotFoundException, IncorrectSocialWorkerException {
    categoryDBGateway.retrieveCategory(categoryId);

    Project project = projectDBGateway.retrieveProject(projectId);

    checker.checkThatProjectIsOurs(project, getUsername(), getRole());

    project.addCategory(categoryId);
  }

  public void moveItem(long destinationProjectId, long destinationCategoryId, long itemId)
      throws ItemNotFoundException, ProjectNotFoundException, ProjectClosedException,
      CategoryNotFoundException, IncorrectSocialWorkerException, ItemNotPendingException {
    Item item = itemDBGateway.retrieveItem(itemId);

    checker.checkThatProjectIsOurs(item.getProject(), getUsername(), getRole());

    if (ItemStatus.PENDING != item.getStatus()) {
      throw new ItemNotPendingException("Can't move an item if it's not in stock");
    }

    Project destinationProject = projectDBGateway.retrieveProject(destinationProjectId);

    if (destinationProject.isClosed()) {
      throw new ProjectClosedException("Trying to move an item to a closed project");
    }
    if (!destinationProject.hasCategory(destinationCategoryId)) {
      throw new CategoryNotFoundException("The category doesn't exist in the destination project");
    }

    item.setProject(destinationProjectId);
    item.setCategory(destinationCategoryId);
  }

  public void returnItemToDonor(long itemId) throws ItemNotFoundException,
      IncorrectSocialWorkerException, IllegalItemStatusTransitionException {
    changeItemStatus(itemId, ItemStatus.RETURNED);
  }

  public void changeItemStatus(long itemId, ItemStatus newStatus) throws ItemNotFoundException,
      IllegalItemStatusTransitionException, IncorrectSocialWorkerException {
    Item item = itemDBGateway.retrieveItem(itemId);

    checker.checkThatProjectIsOurs(item.getProject(), getUsername(), getRole());

    final ItemStatus oldStatus = item.getStatus();
    // check that transition is legal
    if (!isTransitionLegal(oldStatus, newStatus)) {
      throw new IllegalItemStatusTransitionException(getRole().toString(), oldStatus.toString(),
          newStatus.toString());
    }

    // change the status
    item.setStatus(newStatus);
    if (ItemStatus.PENDING == newStatus) {
      // if there's anyone waiting for this item, match them
      String waitingUser = null;
      try {
        waitingUser = projectDBGateway.removeFirstFromWaitingQueue(
            item.getProject().getId(), item.getCategory().getId());
      } catch (EmptyWaitingListException e) {
        // no one is waiting for this category
        return;
      }
      // we just got an item to the stock, and there's someone waiting for it -
      // match them.
      matchItem(item, waitingUser);
    } else if (ItemStatus.RECEIVED == newStatus) {
      // mark that it was received
      ReceivedItem receivedItem = new ReceivedItem(item);
      receivedItem.setReceptionTimestamp(new Date());
    }
  }

  private void matchItem(Item item, String waitingUser) {
    ReceivedItem receivedItem = new ReceivedItem(item);

    receivedItem.setReceiverUsername(waitingUser);
    receivedItem.setStatus(ItemStatus.MATCHED);
  }

  private boolean isTransitionLegal(ItemStatus oldStatus, ItemStatus newStatus) {
    switch (oldStatus) {
    case DONATED:
      return (newStatus == ItemStatus.PENDING);
    case PENDING:
      return (newStatus == ItemStatus.RETURNED);
    case MATCHED:
      return (newStatus == ItemStatus.RECEIVED);
    }
    return false;
  }
}
