package aig.donations;

import aig.donations.exceptions.CategoryNotFoundException;
import aig.donations.exceptions.IllegalCategoryDescriptionException;
import aig.donations.exceptions.IllegalCategoryDescriptionLengthException;
import aig.donations.exceptions.IllegalCategoryNameException;
import aig.donations.exceptions.IllegalCategoryNameLengthException;
import aig.donations.exceptions.IllegalUserNameException;
import aig.donations.exceptions.IllegalUserNameLengthException;
import aig.donations.exceptions.IllegalUserRoleException;
import aig.donations.exceptions.IllegalUserUsernameException;
import aig.donations.exceptions.IllegalUserUsernameLengthException;

public class SystemAdmin extends User {
  protected CategoryDatabaseGateway categoryDBGateway = new CategoryDatabaseGatewayImpl();
  
  SystemAdmin(User user) throws IllegalUserNameLengthException, IllegalUserUsernameLengthException,
      IllegalUserNameException, IllegalUserRoleException, IllegalUserUsernameException {
    super(user.getUsername(), user.getRole(), user.getName());
  }
  
  public long createCategory(String name, String description, long parentId)
      throws CategoryNotFoundException, IllegalCategoryNameLengthException,
      IllegalCategoryNameException, IllegalCategoryDescriptionLengthException,
      IllegalCategoryDescriptionException {
    checker.checkCategoryName(name);
    checker.checkCategoryDescription(description);
    
    // make sure parent category exists
    categoryDBGateway.retrieveCategory(parentId);
    
    return categoryDBGateway.addToDB(name, description, parentId);
  }
  
  public void renameCategory(long id, String newName) throws CategoryNotFoundException,
      IllegalCategoryNameLengthException, IllegalCategoryNameException {
    checker.checkCategoryName(newName);
    
    categoryDBGateway.retrieveCategory(id).setName(newName);
  }
  
  public void moveCategory(long id, long newParent) throws CategoryNotFoundException {
    // make sure parent category exists
    categoryDBGateway.retrieveCategory(newParent);
    
    categoryDBGateway.retrieveCategory(id).setParentId(newParent);
  }
  
  void changeCategoryDescription(long id, String newDescription) throws CategoryNotFoundException,
      IllegalCategoryDescriptionLengthException, IllegalCategoryDescriptionException {
    checker.checkCategoryDescription(newDescription);
    
    categoryDBGateway.retrieveCategory(id).setDescription(newDescription);
  }
  
  void removeCategory(long id) throws CategoryNotFoundException {
    categoryDBGateway.retrieveCategory(id).removeCategory();
  }
  
  void removeUser(String username) {
    // TODO: throws...
    UserDBHandler.removeUser(username);
  }
  
}
