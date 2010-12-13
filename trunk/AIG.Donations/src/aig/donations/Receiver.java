package aig.donations;

import java.util.List;

import aig.donations.exceptions.CategoryDoesNotExistInProjectException;
import aig.donations.exceptions.CategoryIsTopLevelException;
import aig.donations.exceptions.CategoryNotFoundException;
import aig.donations.exceptions.IllegalItemStatusTransitionException;
import aig.donations.exceptions.IllegalUserNameException;
import aig.donations.exceptions.IllegalUserNameLengthException;
import aig.donations.exceptions.IllegalUserRoleException;
import aig.donations.exceptions.IllegalUserUsernameException;
import aig.donations.exceptions.IllegalUserUsernameLengthException;
import aig.donations.exceptions.ItemNotMatchedException;
import aig.donations.exceptions.NoPendingItemsException;
import aig.donations.exceptions.ProjectClosedException;
import aig.donations.exceptions.ProjectNotFoundException;
import aig.donations.exceptions.UserMismatchException;
import aig.donations.exceptions.UserNotInWaitingListException;

public class Receiver extends User {
  protected ReceivedItemDatabaseGateway receivedItemDBGateway = new ReceivedItemDatabaseGatewayImpl();
  //TODO: protected ProjectDatabaseGateway projectDBGateway = new ProjectDatabaseGatewayImpl();
  
  Receiver(User user) throws IllegalUserNameLengthException, IllegalUserUsernameLengthException,
      IllegalUserNameException, IllegalUserRoleException, IllegalUserUsernameException {
    super(user.getUsername(), user.getRole(), user.getName());
  }
  
  public void requestItem(long projectId, long categoryId) throws ProjectClosedException,
      ProjectNotFoundException, CategoryDoesNotExistInProjectException,
      IllegalItemStatusTransitionException, CategoryIsTopLevelException {
    Project project = Project.retrieveProject(projectId); //TODO: projectDBGateway
    if (project.isClosed()) {
      // also checks that the project exists
      throw new ProjectClosedException("Can't request from a closed project");
    }
    if (!project.hasCategory(categoryId)) {
      throw new CategoryDoesNotExistInProjectException("No such category in the project");
    }
    
    try {
      checker.checkCategoryIsntTopLevel(categoryId);
    } catch (CategoryNotFoundException e) {
      throw new AssertionError(e);
    }
    
    Item itemToBeReceived = null;
    try {
      itemToBeReceived = project.getPendingItem(categoryId);
    } catch (NoPendingItemsException e) {
      // no item waiting - add user to waiting queue
      Project.addToWaitingQueue(projectId, categoryId, getUsername()); //TODO: projectDBGateway
      return;
    }
    
    // we found an item. Match it:
    changeItemStatus(new ReceivedItem(itemToBeReceived), ItemStatus.MATCHED);
    
  }
  
  public List<ReceivedItem> getReceivedItems() {
    return receivedItemDBGateway.retrieveReceivedItemsByReceiver(getUsername());
  }
  
  public List<ReceivedItem> getMatchedItems() {
    return receivedItemDBGateway.retrieveMatchedItemsByReceiver(getUsername());
  }
  
  public List<Pair<Project, Category>> getWaitingData() {
    return receivedItemDBGateway.retrieveWaitingDataByReceiver(getUsername());
  }
  
  public void regretItemRequest(long itemId) throws ItemNotMatchedException, UserMismatchException,
      IllegalItemStatusTransitionException {
    ReceivedItem item = receivedItemDBGateway.retrieveItem(itemId);
    
    if (getUsername() != item.getReceiverUsername()) {
      throw new UserMismatchException("Trying to regret a request for an item that doesn't "
          + "belong to the user");
    }
    if (item.getStatus() != ItemStatus.MATCHED) {
      throw new ItemNotMatchedException("Can't regret an item that isn't matched");
    }
    
    changeItemStatus(item, ItemStatus.PENDING);
  }
  
  public void regretCategoryRequest(long projectId, long categoryId)
      throws ProjectNotFoundException, ProjectClosedException,
      CategoryDoesNotExistInProjectException, UserNotInWaitingListException {
    
    // this method is for users who are waiting in waiting queues (items weren't
    // matched)
    // TODO: add previous line to javadoc
    Project project = Project.retrieveProject(projectId); //TODO: projectDBGateway
    if (project.isClosed()) {
      // also checks that the project exists
      throw new ProjectClosedException("Can't regret from a closed project");
    }
    if (!project.hasCategory(categoryId)) {
      throw new CategoryDoesNotExistInProjectException("No such category in the project");
    }
    
    Project.removeUserFromWaitingQueue(projectId, categoryId, getUsername()); //TODO: projectDBGateway
    
  }
  
  private void changeItemStatus(ReceivedItem item, ItemStatus newStatus)
      throws IllegalItemStatusTransitionException {
    ItemStatus oldStatus = item.getStatus();
    if (ItemStatus.PENDING == oldStatus && ItemStatus.MATCHED == newStatus) {
      // PENDING --> MATCHED
      item.setReceiverUsername(getUsername());
    } else if (ItemStatus.MATCHED == oldStatus && ItemStatus.PENDING == newStatus) {
      // MATCHED --> PENDING
      item.setReceiverUsername(null);
    } else {
      throw new IllegalItemStatusTransitionException(getRole().toString(), oldStatus.toString(),
          newStatus.toString());
    }
    
    item.setStatus(newStatus);
  }
  
//TODO- use Project in a way we can use stubs - I put it in TODOs above.
}
