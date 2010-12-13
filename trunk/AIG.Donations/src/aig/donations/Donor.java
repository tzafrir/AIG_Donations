package aig.donations;

import java.util.Date;
import java.util.List;

import aig.donations.exceptions.CategoryDoesNotExistInProjectException;
import aig.donations.exceptions.CategoryIsTopLevelException;
import aig.donations.exceptions.CategoryNotFoundException;
import aig.donations.exceptions.IllegalItemConditionException;
import aig.donations.exceptions.IllegalItemDescriptionException;
import aig.donations.exceptions.IllegalItemDescriptionLengthException;
import aig.donations.exceptions.IllegalItemNameException;
import aig.donations.exceptions.IllegalItemNameLengthException;
import aig.donations.exceptions.IllegalUserNameException;
import aig.donations.exceptions.IllegalUserNameLengthException;
import aig.donations.exceptions.IllegalUserRoleException;
import aig.donations.exceptions.IllegalUserUsernameException;
import aig.donations.exceptions.IllegalUserUsernameLengthException;
import aig.donations.exceptions.ProjectClosedException;
import aig.donations.exceptions.ProjectNotFoundException;

public class Donor extends User {
  
  protected ItemDatabaseGateway itemDBGateway = new ItemDatabaseGatewayImpl();
  // TODO: protected ProjectDatabaseGateway projectDBGateway = new ProjectDatabaseGatewayImpl();
  
  Donor(User user) throws IllegalUserNameLengthException, IllegalUserUsernameLengthException,
      IllegalUserNameException, IllegalUserRoleException, IllegalUserUsernameException {
    super(user.getUsername(), user.getRole(), user.getName());
  }
  
  public long donateItem(long projectId, long categoryId, String itemName, String itemDescription,
      ItemCondition itemCondition) throws ProjectNotFoundException, ProjectClosedException,
      CategoryDoesNotExistInProjectException, IllegalItemConditionException,
      CategoryIsTopLevelException, IllegalItemNameLengthException, IllegalItemNameException,
      IllegalItemDescriptionLengthException, IllegalItemDescriptionException {
    
    Project project = Project.retrieveProject(projectId); // TODO: projectDBGateway.retrieveProject(projectId);
    if (project.isClosed()) {
      // also checks that the project exists
      throw new ProjectClosedException("Can't donate to a closed project");
    }
    if (!project.hasCategory(categoryId)) {
      throw new CategoryDoesNotExistInProjectException("No such category in the project");
    }
    
    try {
      checker.checkCategoryIsntTopLevel(categoryId);
    } catch (CategoryNotFoundException e) {
      throw new AssertionError(e);
    }
    checker.checkItemName(itemName);
    checker.checkItemDescription(itemDescription);
    checker.checkItemCondition(itemCondition);
    
    return itemDBGateway.addToDB(itemName, itemDescription, projectId, categoryId,
        ItemStatus.DONATED, new Date(), getUsername(), itemCondition);
  }
  
  public List<Item> getDonatedItems() {
    return itemDBGateway.retrieveItemsByDonor(getUsername());
  }
  
  // TODO- use Project in a way we can use stubs - I put it in TODOs above.
}
