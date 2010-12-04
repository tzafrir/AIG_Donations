package aig.donations;

import aig.donations.exceptions.*;

/**
 * Represents a user in the system.
 * 
 * The class only holds data needed for the common usage
 * (e.g. the password isn't kept here)
 * 
 * An instance of this class will be kept in the session for each logged-in user.
 *
 */
class User {
	//the username, used for identification in the system
	private String username;
	//the role of the user, out of the available roles
	private Role role;
	//the real name of the user
	private String name;

	
	/* C'tors */
	
	User(String username, Role role, String name)
	throws IllegalNameException, IllegalNameLengthException,
	IllegalRoleException,
	IllegalUsernameException, IllegalUsernameLengthException {
		ParameterLegalityChecker checker = new ParameterLegalityChecker();
		
		checker.checkUsername(username);
		checker.checkRole(role);
		checker.checkUsersName(name);

		this.username = username;
		this.role = role;
		this.name = name;
	}

	
	/* Getters */
	
	String getUsername() {
		return username;
	}

	Role getRole() {
		return role;
	}

	String getName() {
		return name;
	}
}
