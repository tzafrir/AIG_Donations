package aig.donations;

import aig.donations.exceptions.UserAlreadyExistsException;
import aig.donations.exceptions.UserNotFoundException;

class UserDBHandler {
  
  String retrievePassword(String username) throws UserNotFoundException {
    // TODO Auto-generated method stub
    return null;
  }
  
  /*
   * static Role retrieveRole(String username) { // TODO Auto-generated method
   * stub return null; }
   * 
   * static String retrieveName(String username) { // TODO Auto-generated method
   * stub return null; }
   */

  User retrieveUser(String username) {
    // TODO Auto-generated method stub
    return null;
  }
  
  void addToDB(String username, Role role, String name, String password)
      throws UserAlreadyExistsException {
    // TODO Auto-generated method stub
    // TODO: this should throw if such a user (username) already exists
    
  }
  
  void removeUser(String username) throws UserNotFoundException {
    // TODO Auto-generated method stub
    // TODO: should throw if user doesn't exist
  }
  
}
