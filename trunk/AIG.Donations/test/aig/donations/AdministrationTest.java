package aig.donations;

import static org.junit.Assert.fail;

import java.util.LinkedList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import aig.donations.exceptions.*;

public class AdministrationTest {
  
  private static LinkedList<String> addedUsernames = new LinkedList<String>();
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }
  
  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    for (String username : addedUsernames) {
      UserDBHandler.removeUser(username);
    }
  }
  
  @Test
  public void testSignUpLegalData() throws IllegalPasswordLengthException,
      IllegalPasswordException, UserAlreadyExistsException {
    final String newUsername = "humpty";
    Administration.signUp(newUsername, Role.DONOR, "dumpty", "abc123ABC~!@");
    addedUsernames.add(newUsername);
  }
  
  @Test(expected = IllegalPasswordException.class)
  public void testSignUpIllegalPasswordNull() throws IllegalPasswordLengthException,
      IllegalPasswordException, UserAlreadyExistsException {
    final String newUsername = "humpty";
    Administration.signUp(newUsername, Role.DONOR, "dumpty", null);
    addedUsernames.add(newUsername);
  }
  
  @Test(expected = IllegalPasswordLengthException.class)
  public void testSignUpIllegalPasswordTooShort() throws IllegalPasswordLengthException,
      IllegalPasswordException, UserAlreadyExistsException {
    final String newUsername = "humpty";
    Administration.signUp(newUsername, Role.DONOR, "dumpty", "abc12");
    addedUsernames.add(newUsername);
  }
  
  @Test(expected = IllegalPasswordLengthException.class)
  public void testSignUpIllegalPasswordTooLong() throws IllegalPasswordLengthException,
      IllegalPasswordException, UserAlreadyExistsException {
    final String newUsername = "humpty";
    Administration.signUp(newUsername, Role.DONOR, "dumpty", "123451234512345123456");
    addedUsernames.add(newUsername);
  }
  
  @Test /*(expected = UserAlreadyExistsException.class)*/
  public void testSignUpUserAlreadyExists(){
    fail("Not yet implemented");
  }
  
  /**** Login tests ****/
  
  @Test
  public void testLogin(){
    fail("Not yet implemented");
  }
  
  @Test /*(expected = BadLoginException.class)*/
  public void testLoginNullUsername(){
    fail("Not yet implemented");
  }
  
  @Test /*(expected = BadLoginException.class)*/
  public void testLoginNullInputPassword(){
    fail("Not yet implemented");
  }
  
  @Test /*(expected = BadLoginException.class)*/
  public void testLoginUsernameDoesntExist(){
    fail("Not yet implemented");
  }
  
  @Test /*(expected = BadLoginException.class)*/
  public void testLoginPasswordDoesntMatch(){
    fail("Not yet implemented");
  }
  
}
