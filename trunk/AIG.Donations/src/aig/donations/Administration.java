package aig.donations;

import aig.donations.exceptions.IllegalPasswordException;
import aig.donations.exceptions.IllegalPasswordLengthException;
import aig.donations.exceptions.UserAlreadyExistsException;
import aig.donations.exceptions.UserNotFoundException;

class Administration {
  
  static void signUp(String username, Role role, String name, String password)
      throws IllegalPasswordException, IllegalPasswordLengthException, UserAlreadyExistsException {
    // check username, role and name:
    new User(username, role, name);
    
    new ParameterLegalityChecker().checkPassword(password);
    
    UserDBHandler.addToDB(username, role, name, password);
  }
  
  static boolean login(String username, String password) {
    String realPassword = null;
    try {
      realPassword = UserDBHandler.retrievePassword(username);
    } catch (UserNotFoundException e) {
      return false; // bad user
    }
    if (null == realPassword || !realPassword.equals(password)) {
      return false; // bad password
    }
    
    User user = UserDBHandler.retrieveUser(username);
    
    saveUserInSession(user);
    
    return true;
  }
  
  static void logout() {
    removeUserFromSession();
  }
  
  private static void saveUserInSession(User user) {
    // TODO Auto-generated method stub
    // TODO: if a User already exists in the session, replace it (or throw?)
  }
  
  private static void removeUserFromSession() {
    // TODO Auto-generated method stub
    // TODO: throw if no User in the session
  }
  
}
