package aig.donations;

import org.junit.Test;

import aig.donations.exceptions.*;

public class UserTest {
  
  /* C'tor username parameter tests: */
  @Test
  public void testCtorLegalUsername1() throws IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    new User("a", Role.DONOR, "name");
  }
  
  @Test
  public void testCtorLegalUsername2() throws IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    new User("abcdefgh_ASD98", Role.DONOR, "name");
  }
  
  @Test
  public void testCtorLegalUsername3() throws IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    new User("abababababababababab", Role.RECEIVER, "name");
  }
  
  @Test(expected = IllegalUserUsernameException.class)
  public void testCtorIllegalUsernameNull() throws IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    new User(null, Role.DONOR, "name");
  }
  
  @Test(expected = IllegalUserUsernameException.class)
  public void testCtorIllegalUsernameIllegalChar1() throws IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    new User("!", Role.DONOR, "name");
  }
  
  @Test(expected = IllegalUserUsernameException.class)
  public void testCtorIllegalUsernameIllegalChar2() throws IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    new User("asdf_56^6", Role.DONOR, "name");
  }
  
  @Test(expected = IllegalUserUsernameLengthException.class)
  public void testCtorIllegalUsernameTooShort() throws IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    new User("", Role.DONOR, "name");
  }
  
  @Test(expected = IllegalUserUsernameLengthException.class)
  public void testCtorIllegalUsernameTooLong() throws IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    new User("abcdabcdabcdabcdabcde", Role.DONOR, "name");
  }
  
  /* C'tor name parameter tests: */

  @Test
  public void testCtorLegalName1() throws IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    new User("username", Role.DONOR, "ed");
  }
  
  @Test
  public void testCtorLegalName2() throws IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    new User("username", Role.SOCIAL_WORKER, "Cheshire cat");
  }
  
  @Test
  public void testCtorLegalName3() throws IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    new User("username", Role.SYSTEM_ADMIN, "Bob the first");
  }
  
  @Test(expected = IllegalUserNameException.class)
  public void testCtorIllegalNameNull() throws IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    new User("username", Role.DONOR, null);
  }
  
  @Test(expected = IllegalUserNameException.class)
  public void testCtorIllegalNameIllegalChar1() throws IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    new User("username", Role.DONOR, "C. Cat");
  }
  
  @Test(expected = IllegalUserNameException.class)
  public void testCtorIllegalNameIllegalChar2() throws IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    new User("username", Role.DONOR, "@1*c3");
  }
  
  @Test(expected = IllegalUserNameLengthException.class)
  public void testCtorIllegalNameTooShort() throws IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    new User("username", Role.DONOR, "a");
  }
  
  @Test(expected = IllegalUserNameLengthException.class)
  public void testCtorIllegalNameTooLong() throws IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    new User("username", Role.DONOR, "longlonglonglonglonglonglonglonglonglonglonglonglox");
  }
  
  /* C'tor role parameter tests: */

  @Test(expected = IllegalUserRoleException.class)
  public void testCtorIllegalRoleNull() throws IllegalUserNameLengthException,
      IllegalUserUsernameLengthException, IllegalUserNameException, IllegalUserRoleException,
      IllegalUserUsernameException {
    new User("username", null, "name");
  }
  
}
