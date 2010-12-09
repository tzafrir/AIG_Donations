package aig.donations;

import java.util.Date;

import aig.donations.exceptions.CategoryNotFoundException;
import aig.donations.exceptions.EmptyWaitingListException;
import aig.donations.exceptions.IllegalItemStatusTransitionException;
import aig.donations.exceptions.ItemNotFoundException;
import aig.donations.exceptions.ProjectAlreadyClosedException;
import aig.donations.exceptions.ProjectClosedException;
import aig.donations.exceptions.ProjectNotFoundException;

class SocialWorker extends User {
  
  SocialWorker(User user) {
    super(user.getUsername(), user.getRole(), user.getName());
  }
  
  long createProject(String name, String description, String location, Date eventTime) {
    ParameterLegalityChecker checker = new ParameterLegalityChecker();
    checker.checkProjectName(name);
    checker.checkProjectDescription(description);
    checker.checkProjectLocation(location);
    checker.checkProjectEventTime(eventTime);
    return Project.addToDB(name, description, location, eventTime);
  }
  
  void closeProject(long projectId) throws ProjectNotFoundException, ProjectAlreadyClosedException {
    Project project = Project.retrieveProject(projectId);
    
    if (project.isClosed()) {
      throw new ProjectAlreadyClosedException("can't close a project that is already closed");
    }
    
    project.setEventTime(new Date());
  }
  
  void renameProject(long projectId, String newName) throws ProjectNotFoundException {
    new ParameterLegalityChecker().checkProjectName(newName);
    
    Project.retrieveProject(projectId).setName(newName);
  }
  
  void changeProjectDescription(long projectId, String newDescription)
      throws ProjectNotFoundException {
    new ParameterLegalityChecker().checkProjectDescription(newDescription);
    
    Project.retrieveProject(projectId).setDescription(newDescription);
  }
  
  void changeProjectLocation(long projectId, String newLocation) throws ProjectNotFoundException {
    new ParameterLegalityChecker().checkProjectLocation(newLocation);
    
    Project.retrieveProject(projectId).setLocation(newLocation);
  }
  
  void changeProjectTime(long projectId, Date newEventTime) throws ProjectNotFoundException {
    new ParameterLegalityChecker().checkProjectEventTime(newEventTime);
    
    Project.retrieveProject(projectId).setEventTime(newEventTime);
  }
  
  void addCategoryToProject(long projectId, long categoryId) throws ProjectNotFoundException,
      CategoryNotFoundException {
    // make sure category exists:
    new Category().retrieveCategory(categoryId);
    
    Project.retrieveProject(projectId).addCategory(categoryId);
  }
  
  void moveItem(long destinationProjectId, long destinationCategoryId, long itemId)
      throws ItemNotFoundException, ProjectNotFoundException, ProjectClosedException {
    Item item = Item.retrieveItem(itemId);
    
    Project destinationProject = Project.retrieveProject(destinationProjectId);
    if (destinationProject.isClosed()) {
      throw new ProjectClosedException("Trying to move an item to a closed project");
    }
    
    item.setProject(destinationProjectId);
    item.setCategory(destinationCategoryId);
    //TODO- does destinationCategoryId exist in project? need to check?
  }
  
  void changeItemStatus(long itemId, ItemStatus newStatus) throws ItemNotFoundException,
      IllegalItemStatusTransitionException {
    Item item = Item.retrieveItem(itemId);
    
    final ItemStatus oldStatus = item.getStatus();
    if (!isTransitionLegal(oldStatus, newStatus)) {
      throw new IllegalItemStatusTransitionException(getRole().toString(), oldStatus.toString(),
          newStatus.toString());
    }
    
    item.setStatus(newStatus);
    if (ItemStatus.PENDING == newStatus) {
      String waitingUser = null;
      try {
        waitingUser = Project.removeFirstFromWaitingQueue(item.getProject().getId(), item
            .getCategory().getId());
      } catch (EmptyWaitingListException e) {
        // no one is waiting for this category
        return;
      }
      matchItem(item, waitingUser);
    } else if (ItemStatus.RECEIVED == newStatus) {
      ReceivedItem receivedItem = new ReceivedItem(item);
      receivedItem.setReceptionTimestamp(new Date());
    }
    // TODO: transferred --> change item's project and category
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
