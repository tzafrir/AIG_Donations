package aig.donations;

import org.junit.Test;

import aig.donations.exceptions.*;

public class UserTest {

/* C'tor username parameter tests: */
	@Test
	public void testCtorLegalUsername1() {
		new User("a", Role.DONOR, "name");
	}

	@Test
	public void testCtorLegalUsername2() {
		new User("abcdefgh_ASD98", Role.DONOR, "name");
	}

	@Test
	public void testCtorLegalUsername3() {
		new User("abababababababababab", Role.RECEIVER, "name");
	}

	@Test(expected=IllegalUsernameException.class)
	public void testCtorIllegalUsernameNull() {
		new User(null, Role.DONOR, "name");
	}

	@Test(expected=IllegalUsernameException.class)
	public void testCtorIllegalUsernameIllegalChar1() {
		new User("!", Role.DONOR, "name");
	}

	@Test(expected=IllegalUsernameException.class)
	public void testCtorIllegalUsernameIllegalChar2() {
		new User("asdf_56^6", Role.DONOR, "name");
	}

	@Test(expected=IllegalUsernameLengthException.class)
	public void testCtorIllegalUsernameTooShort() {
		new User("", Role.DONOR, "name");
	}

	@Test(expected=IllegalUsernameLengthException.class)
	public void testCtorIllegalUsernameTooLong() {
		new User("abcdabcdabcdabcdabcde", Role.DONOR, "name");
	}

	
	/* C'tor name parameter tests: */
	
	@Test
	public void testCtorLegalName1() {
		new User("username", Role.DONOR, "ed");
	}

	@Test
	public void testCtorLegalName2() {
		new User("username", Role.SOCIAL_WORKER, "Cheshire cat");
	}

	@Test
	public void testCtorLegalName3() {
		new User("username", Role.SYSTEM_ADMIN, "Bob the first");
	}

	@Test(expected=IllegalNameException.class)
	public void testCtorIllegalNameNull() {
		new User("username", Role.DONOR, null);
	}

	@Test(expected=IllegalNameException.class)
	public void testCtorIllegalNameIllegalChar1() {
		new User("username", Role.DONOR, "C. Cat");
	}

	@Test(expected=IllegalNameException.class)
	public void testCtorIllegalNameIllegalChar2() {
		new User("username", Role.DONOR, "@1*c3");
	}

	@Test(expected=IllegalNameLengthException.class)
	public void testCtorIllegalNameTooShort() {
		new User("username", Role.DONOR, "a");
	}

	@Test(expected=IllegalNameLengthException.class)
	public void testCtorIllegalNameTooLong() {
		new User("username", Role.DONOR, "longlonglonglonglonglonglonglonglonglonglonglonglox");
	}

	
	/* C'tor role parameter tests: */
	
	@Test(expected=IllegalRoleException.class)
	public void testCtorIllegalRoleNull() {
		new User("username", null, "name");
	}

}
