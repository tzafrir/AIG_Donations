package aig.donations;

import aig.donations.exceptions.IllegalPasswordException;
import aig.donations.exceptions.IllegalPasswordLengthException;

class Administration {
  
  // length limitations on the password
  private final static int MAX_PASSWORD_LENGTH = 20;
  private final static int MIN_PASSWORD_LENGTH = 6;
  
  static void signUp(String username, Role role, String name, String password)
      throws IllegalPasswordException, IllegalPasswordLengthException {
    // check username, role and name:
    new User(username, role, name);
    
    checkPassword(password);
    
    UserDBHandler.addToDB(username, role, name, password); // TODO: make sure
                                                           // this throws if
                                                           // such a user
                                                           // already exists
  }
  
  private static void checkPassword(String password) throws IllegalPasswordException,
      IllegalPasswordLengthException {
    if (null == password) {
      throw new IllegalPasswordException("password is null");
    }
    
    if (password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
      throw new IllegalPasswordLengthException(MIN_PASSWORD_LENGTH, MAX_PASSWORD_LENGTH);
    }
    
  }
  
  static boolean login(String username, String password) {
    String realPassword = UserDBHandler.retrievePassword(username);
    if (null == realPassword || !realPassword.equals(password)) {
      return false; // bad password or username
    }
    User user = new User(username, UserDBHandler.retrieveRole(username),
        UserDBHandler.retrieveName(username));
    
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
