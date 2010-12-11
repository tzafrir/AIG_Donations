package aig.donations;

import java.util.LinkedList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import aig.donations.exceptions.*;

public class AdministrationTest {
  
  private static LinkedList<String> addedUsernames = new LinkedList<String>();
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    String newUsername = "mad";
    Administration.signUp(newUsername, Role.DONOR, "hatter", "12341234");
    addedUsernames.add(newUsername);
    newUsername = "Q";
    Administration.signUp(newUsername, Role.SYSTEM_ADMIN, "red queen", "asdf1234");
    addedUsernames.add(newUsername);
  }
  
  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    for (String username : addedUsernames) {
      UserDBHandler.removeUser(username);
    }
  }
  
  @Test
  public void testSignUpLegalData() throws IllegalPasswordLengthException,
      IllegalPasswordException, UserAlreadyExistsException, IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    final String newUsername = "humpty";
    Administration.signUp(newUsername, Role.DONOR, "dumpty", "abc123ABC~!@");
    addedUsernames.add(newUsername);
  }
  
  @Test
  public void testSignUpSameDataDifferentUsername() throws IllegalPasswordLengthException,
      IllegalPasswordException, UserAlreadyExistsException, IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    final String newUsername = "q";
    Administration.signUp(newUsername, Role.SYSTEM_ADMIN, "red queen", "asdf1234");
    addedUsernames.add(newUsername);
  }
  
  @Test(expected = IllegalPasswordException.class)
  public void testSignUpIllegalPasswordNull() throws IllegalPasswordLengthException,
      IllegalPasswordException, UserAlreadyExistsException, IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    final String newUsername = "humpty";
    Administration.signUp(newUsername, Role.DONOR, "dumpty", null);
    addedUsernames.add(newUsername);
  }
  
  @Test(expected = IllegalPasswordLengthException.class)
  public void testSignUpIllegalPasswordTooShort() throws IllegalPasswordLengthException,
      IllegalPasswordException, UserAlreadyExistsException, IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    final String newUsername = "humpty";
    Administration.signUp(newUsername, Role.DONOR, "dumpty", "abc12");
    addedUsernames.add(newUsername);
  }
  
  @Test(expected = IllegalPasswordLengthException.class)
  public void testSignUpIllegalPasswordTooLong() throws IllegalPasswordLengthException,
      IllegalPasswordException, UserAlreadyExistsException, IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    final String newUsername = "humpty";
    Administration.signUp(newUsername, Role.DONOR, "dumpty", "123451234512345123456");
    addedUsernames.add(newUsername);
  }
  
  @Test(expected = UserAlreadyExistsException.class)
  public void testSignUpUserAlreadyExists() throws IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalPasswordLengthException, IllegalUserNameException,
      IllegalUserRoleException, IllegalUserUsernameException, IllegalPasswordException,
      UserAlreadyExistsException {
    Administration.signUp("mad", Role.RECEIVER, "brother", "asdfasdf");
    addedUsernames.add("mad");
  }
  
  /**** Login tests ****/
  
  @Test
  public void testLogin() throws BadLoginException {
    Administration.login("Q", "asdf1234");
  }
  
  @Test(expected = BadLoginException.class)
  public void testLoginNullUsername() throws BadLoginException {
    Administration.login(null, "asdf1234");
  }
  
  @Test(expected = BadLoginException.class)
  public void testLoginNullInputPassword() throws BadLoginException {
    Administration.login("Q", null);
  }
  
  @Test(expected = BadLoginException.class)
  public void testLoginUsernameDoesntExist() throws BadLoginException {
    Administration.login("q", "asdf1234");
  }
  
  @Test(expected = BadLoginException.class)
  public void testLoginPasswordDoesntMatch() throws BadLoginException {
    Administration.login("Q", "asdf12345");
  }
  
}
