package aig.donations;

import org.junit.Test;

import aig.donations.exceptions.*;

public class AdministrationTest {
  
  private Administration administration = new Administration(new UserDBHandlerStub());
  
  @Test
  public void testSignUpLegalData() throws IllegalPasswordLengthException,
      IllegalPasswordException, UserAlreadyExistsException, IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    administration.signUp("humpty", Role.DONOR, "dumpty", "abc123ABC~!@");
  }
  
  @Test
  public void testSignUpSameDataDifferentUsername() throws IllegalPasswordLengthException,
      IllegalPasswordException, UserAlreadyExistsException, IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    administration.signUp("Q", Role.SYSTEM_ADMIN, "red queen", "asdf1234");
    administration.signUp("q", Role.SYSTEM_ADMIN, "red queen", "asdf1234");
  }
  
  @Test(expected = IllegalPasswordException.class)
  public void testSignUpIllegalPasswordNull() throws IllegalPasswordLengthException,
      IllegalPasswordException, UserAlreadyExistsException, IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    administration.signUp("queen", Role.DONOR, "dumpty", null);
  }
  
  @Test(expected = IllegalPasswordLengthException.class)
  public void testSignUpIllegalPasswordTooShort() throws IllegalPasswordLengthException,
      IllegalPasswordException, UserAlreadyExistsException, IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    administration.signUp("queen", Role.DONOR, "dumpty", "abc12");
  }
  
  @Test(expected = IllegalPasswordLengthException.class)
  public void testSignUpIllegalPasswordTooLong() throws IllegalPasswordLengthException,
      IllegalPasswordException, UserAlreadyExistsException, IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    administration.signUp("queen", Role.DONOR, "dumpty", "123451234512345123456");
  }
  
  @Test(expected = UserAlreadyExistsException.class)
  public void testSignUpUserAlreadyExists() throws IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalPasswordLengthException, IllegalUserNameException,
      IllegalUserRoleException, IllegalUserUsernameException, IllegalPasswordException,
      UserAlreadyExistsException {
    administration.signUp("mad", Role.RECEIVER, "brother", "asdfasdf");
    administration.signUp("mad", Role.DONOR, "moshe", "badPassword");
  }
  
  /**** Login tests ****/
  
  @Test
  public void testLogin() throws BadLoginException {
    administration.login("Q", "asdf1234");
  }
  
  @Test(expected = BadLoginException.class)
  public void testLoginNullUsername() throws BadLoginException {
    administration.login(null, "asdf1234");
  }
  
  @Test(expected = BadLoginException.class)
  public void testLoginNullInputPassword() throws BadLoginException {
    administration.login("Q", null);
  }
  
  @Test(expected = BadLoginException.class)
  public void testLoginUsernameDoesntExist() throws BadLoginException {
    administration.login("abc", "asdf1234");
  }
  
  @Test(expected = BadLoginException.class)
  public void testLoginPasswordDoesntMatch() throws BadLoginException {
    administration.login("Q", "asdf12345");
  }
  
  private class UserDBHandlerStub extends UserDBHandler {
    
    String retrievePassword(String username) throws UserNotFoundException {
      if("abc".equals(username)) {
        throw new UserNotFoundException("");
      }
      return "asdf1234";
    }

    void addToDB(String username, Role role, String name, String password)
        throws UserAlreadyExistsException {
      if("mad".equals(username) && "moshe".equals(name)) {
        throw new UserAlreadyExistsException();
      }
    }
  }
  
}
