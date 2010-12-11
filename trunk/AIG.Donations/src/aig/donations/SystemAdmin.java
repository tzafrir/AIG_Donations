package aig.donations;

import aig.donations.exceptions.CategoryNotFoundException;

public class SystemAdmin extends User {
  protected CategoryDatabaseGateway categoryDBGateway = new CategoryDatabaseGatewayImpl();
  
  SystemAdmin(User user) {
    super(user.getUsername(), user.getRole(), user.getName());
  }
  
  public long createCategory(String name, String description, long parentId)
      throws CategoryNotFoundException {
    // TODO: throws...
    checker.checkCategoryName(name);
    checker.checkCategoryDescription(name);
    
    // make sure parent category exists
    categoryDBGateway.retrieveCategory(parentId);
    
    return categoryDBGateway.addToDB(name, description, parentId);
  }
  
  public void renameCategory(long id, String newName) throws CategoryNotFoundException {
    // TODO: throws...
    new ParameterLegalityChecker().checkCategoryName(newName);
    
    categoryDBGateway.retrieveCategory(id).setName(newName);
  }
  
  public void moveCategory(long id, long newParent) throws CategoryNotFoundException {
    // TODO: throws...
    // make sure parent category exists
    categoryDBGateway.retrieveCategory(newParent);
    
    categoryDBGateway.retrieveCategory(id).setParentId(newParent);
  }
  
  void changeCategoryDescription(long id, String newDescription) throws CategoryNotFoundException {
    // TODO: throws...
    checker.checkCategoryDescription(newDescription);
    
    categoryDBGateway.retrieveCategory(id).setDescription(newDescription);
  }
  
  void removeCategory(long id) throws CategoryNotFoundException {
    // TODO: throws...
    categoryDBGateway.retrieveCategory(id).removeCategory();
  }
  
  void removeUser(String username) {
    // TODO: throws...
    UserDBHandler.removeUser(username);
  }
  
}
