package aig.donations;

import aig.donations.exceptions.CategoryNotFoundException;

class SystemAdmin extends User {

	SystemAdmin(User user) {
	  super(user.getUsername(), user.getRole(), user.getName());
  }
	
	long createCategory(String name, String description, long parentId) {
		//TODO: throws...
		ParameterLegalityChecker checker = new ParameterLegalityChecker();
		
		checker.checkCategoryName(name);
		checker.checkCategoryDescription(name);
	  
		//make sure parent category exists
    // TODO(tzafrir/eran): Store a Cat gateway in a variable.
    CategoryDatabaseGatewayImpl gateway = new CategoryDatabaseGatewayImpl();
    try {
      gateway.retrieveCategory(parentId);
    } catch (CategoryNotFoundException e) {
      // TODO: Handle.
    }

    return gateway.addToDB(name, description, parentId);
	}
	
	void renameCategory(long id, String newName) {
	  //TODO: throws...
		new ParameterLegalityChecker().checkCategoryName(newName);

    // TODO(tzafrir/eran): Store a Cat gateway in a variable.
    try {
      new CategoryDatabaseGatewayImpl().retrieveCategory(id).setName(newName);
    } catch (CategoryNotFoundException e) {
      // TODO: Handle.
    }
	}
	
	void moveCategory(long id, long newParent) {
	  //TODO: throws...
	  //make sure parent category exists
		// TODO(tzafrir/eran): Store a Cat gateway in a variable.
    CategoryDatabaseGatewayImpl gateway = new CategoryDatabaseGatewayImpl();
    try {
      gateway.retrieveCategory(newParent);
    } catch (CategoryNotFoundException e) {
      // TODO: Handle.
    }

    try {
      gateway.retrieveCategory(id).setParentId(newParent);
    } catch (CategoryNotFoundException e) {
      // TODO: Handle.
    }
	}
	
	void changeCategoryDescription(long id, String newDescription) {
	  //TODO: throws...
		new ParameterLegalityChecker().checkCategoryDescription(newDescription);

    // TODO(tzafrir/eran): gateway variable...
    try {
      new CategoryDatabaseGatewayImpl().retrieveCategory(id).setDescription(newDescription);
    } catch (CategoryNotFoundException e) {
      // TODO: Handle.
    }
	}
	
	void removeCategory(long id) {
	  //TODO: throws...

    // TODO(tzafrir/eran): gateway variable...
    try {
      new CategoryDatabaseGatewayImpl().retrieveCategory(id).removeCategory();
    } catch (CategoryNotFoundException e) {
      // TODO: Handle.
    }
	}
	
	void removeUser(String username) {
	  //TODO: throws...
		UserDBHandler.removeUser(username);
	}
	
}
