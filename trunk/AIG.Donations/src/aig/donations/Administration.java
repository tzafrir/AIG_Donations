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

public class Administration {
  
  private UserDBHandler userDBHandler = new UserDBHandler();
  
  public Administration() {}
  
  public Administration (UserDBHandler userDBHandler) {
    this.userDBHandler = userDBHandler;
  }
  
  public void signUp(String username, Role role, String name, String password)
      throws IllegalUserNameException, IllegalUserNameLengthException, IllegalUserRoleException,
      IllegalUserUsernameException, IllegalUserUsernameLengthException, IllegalPasswordException,
      IllegalPasswordLengthException, UserAlreadyExistsException {
    // check username, role and name:
    new User(username, role, name);
    
    new ParameterLegalityChecker().checkPassword(password);
    
    userDBHandler.addToDB(username, role, name, password);
  }
  
  public User login(String username, String password) throws BadLoginException {
    ParameterLegalityChecker checker = new ParameterLegalityChecker();
    
    String realPassword = null;
    try {
      checker.checkUserUsername(username);
      checker.checkPassword(password);
      realPassword = userDBHandler.retrievePassword(username);
    } catch (UserNotFoundException e) {
      throw new BadLoginException(); // user doesn't exist
    } catch (IllegalUserUsernameException e) {
      throw new BadLoginException(); // bad username
    } catch (IllegalPasswordException e) {
      throw new BadLoginException(); // bad password
    }
    if (null == realPassword || !realPassword.equals(password)) {
      throw new BadLoginException(); // bad password
    }
    
    return userDBHandler.retrieveUser(username);
  }
  
}
