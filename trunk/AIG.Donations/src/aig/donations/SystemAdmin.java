package aig.donations;

class SystemAdmin extends User {
  
  SystemAdmin(User user) {
    super(user.getUsername(), user.getRole(), user.getName());
  }
  
  long createCategory(String name, String description, long parentId) {
    // TODO: throws...
    
    checker.checkCategoryName(name);
    checker.checkCategoryDescription(name);
    
    // make sure parent category exists
    /*
     * Category.retrieveCategory(parentId);
     * 
     * return Category.addToDB(name, description, parentId);
     */
    // TODO: temporarily removed, so code will compile, until tzafrir will
    // upload his update
    return 0; // TODO: "stub" return
  }
  
  void renameCategory(long id, String newName) {
    // TODO: throws...
    checker.checkCategoryName(newName);
    
    // Category.retrieveCategory(id).setName(newName);
    // TODO: temporarily removed, so code will compile, until tzafrir will
    // upload his update
  }
  
  void moveCategory(long id, long newParent) {
    // TODO: throws...
    // make sure parent category exists
    /*
     * Category.retrieveCategory(newParent);
     * 
     * Category.retrieveCategory(id).setParentId(newParent);
     */
    // TODO: temporarily removed, so code will compile, until tzafrir will
    // upload his update
  }
  
  void changeCategoryDescription(long id, String newDescription) {
    // TODO: throws...
    checker.checkCategoryDescription(newDescription);
    
    // Category.retrieveCategory(id).setDescription(newDescription);
    // TODO: temporarily removed, so code will compile, until tzafrir will
    // upload his update
  }
  
  void removeCategory(long id) {
    // TODO: throws...
    // Category.retrieveCategory(id).removeCategory();
    // TODO: temporarily removed, so code will compile, until tzafrir will
    // upload his update
  }
  
  void removeUser(String username) {
    // TODO: throws...
    UserDBHandler.removeUser(username);
  }
  
}
