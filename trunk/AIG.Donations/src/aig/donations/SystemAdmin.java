package aig.donations;

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
		Category.retrieveCategory(parentId);
		
		return Category.addToDB(name, description, parentId);
	}
	
	void renameCategory(long id, String newName) {
	  //TODO: throws...
		new ParameterLegalityChecker().checkCategoryName(newName);
		
		Category.retrieveCategory(id).setName(newName);
	}
	
	void moveCategory(long id, long newParent) {
	  //TODO: throws...
	  //make sure parent category exists
		Category.retrieveCategory(newParent);
		
		Category.retrieveCategory(id).setParentId(newParent);
	}
	
	void changeCategoryDescription(long id, String newDescription) {
	  //TODO: throws...
		new ParameterLegalityChecker().checkCategoryDescription(newDescription);
		
		Category.retrieveCategory(id).setDescription(newDescription);
	}
	
	void removeCategory(long id) {
	  //TODO: throws...
		Category.retrieveCategory(id).removeCategory();
	}
	
	void removeUser(String username) {
	  //TODO: throws...
		UserDBHandler.removeUser(username);
	}
	
}
