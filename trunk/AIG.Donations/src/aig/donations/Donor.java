package aig.donations;

import java.util.Date;
import java.util.List;

import aig.donations.exceptions.CategoryDoesNotExistInProjectException;
import aig.donations.exceptions.CategoryNotFoundException;
import aig.donations.exceptions.IllegalItemConditionException;
import aig.donations.exceptions.ProjectClosedException;
import aig.donations.exceptions.ProjectNotFoundException;

class Donor extends User {
  
  Donor(User user) {
    super(user.getUsername(), user.getRole(), user.getName());
  }
  
  long donateItem(long projectId, long categoryId, String itemName, String itemDescription,
      ItemCondition itemCondition) throws ProjectNotFoundException, ProjectClosedException,
      CategoryDoesNotExistInProjectException, IllegalItemConditionException {
    
    Project project = Project.retrieveProject(projectId);
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
    
    return Item.addToDB(itemName, itemDescription, projectId, categoryId, ItemStatus.DONATED,
        new Date(), getUsername(), itemCondition);
  }
  
  List<Item> getDonatedItems() {
    return Item.retrieveItemsByDonor(getUsername());
  }
}
