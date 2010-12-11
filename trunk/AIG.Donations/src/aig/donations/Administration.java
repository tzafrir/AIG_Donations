package aig.donations;

import aig.donations.exceptions.BadLoginException;
import aig.donations.exceptions.IllegalPasswordException;
import aig.donations.exceptions.IllegalPasswordLengthException;
import aig.donations.exceptions.IllegalUserNameException;
import aig.donations.exceptions.IllegalUserNameLengthException;
import aig.donations.exceptions.IllegalUserRoleException;
import aig.donations.exceptions.IllegalUserUsernameException;
import aig.donations.exceptions.IllegalUserUsernameLengthException;
import aig.donations.exceptions.UserAlreadyExistsException;
import aig.donations.exceptions.UserNotFoundException;

class Administration {
  
  static void signUp(String username, Role role, String name, String password)
      throws IllegalUserNameException, IllegalUserNameLengthException, IllegalUserRoleException,
      IllegalUserUsernameException, IllegalUserUsernameLengthException, IllegalPasswordException,
      IllegalPasswordLengthException, UserAlreadyExistsException {
    // check username, role and name:
    new User(username, role, name);
    
    new ParameterLegalityChecker().checkPassword(password);
    
    UserDBHandler.addToDB(username, role, name, password);
  }
  
  static User login(String username, String password) throws BadLoginException {
    String realPassword = null;
    try {
      realPassword = UserDBHandler.retrievePassword(username);
    } catch (UserNotFoundException e) {
      throw new BadLoginException(); // bad user
    }
    if (null == realPassword || !realPassword.equals(password)) {
      throw new BadLoginException(); // bad password
    }
    
    return UserDBHandler.retrieveUser(username);
  }
  
}
