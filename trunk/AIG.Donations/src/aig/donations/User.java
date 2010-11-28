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

	//length limitations on the users' fields
	private final static int MAX_USERNAME_LENGTH = 20; 
	private final static int MIN_USERNAME_LENGTH = 1; 
	private final static int MAX_NAME_LENGTH = 50;
	private final static int MIN_NAME_LENGTH = 2;
	
	//structural limitations on the users' fields
	private final static String LEGAL_USERNAME_REGEX = "[a-zA-Z_0-9]*";
	private final static String LEGAL_NAME_REGEX = "[a-zA-Z ]*";
	
	/* C'tors */
	
	User(String username, Role role, String name)
	throws IllegalNameException, IllegalNameLengthException,
	IllegalRoleException,
	IllegalUsernameException, IllegalUsernameLengthException {
		checkUsername(username);
		checkRole(role);
		checkName(name);

		this.username = username;
		this.role = role;
		this.name = name;
	}

	/* parameter legality checkers */
	
	/**
	 * Checks legality of a user's real name.
	 * @param name - the name to check
	 * @throws IllegalNameLengthException if the name is of an illegal length
	 * @throws IllegalNameException if the name is illegal for any other reason
	 */
	private static void checkName(String name)
	throws IllegalNameException, IllegalNameLengthException {
		if (null == name) {
			throw new IllegalNameException("name is null");
		}
		if (name.length() < MIN_NAME_LENGTH ||
				name.length() > MAX_NAME_LENGTH) {
			throw new IllegalNameLengthException(MIN_NAME_LENGTH, MAX_NAME_LENGTH);
		}
		if (!name.matches(LEGAL_NAME_REGEX)) {
			throw new IllegalNameException("name has illegal characters");
		}
	}

	/**
	 * Checks legality of a user's role.
	 * @param role - the role to check
	 * @throws IllegalRoleException if the role is illegal
	 */
	private static void checkRole(Role role) throws IllegalRoleException {
		if (null == role) {
			throw new IllegalRoleException("role is null");
		}
	}

	/**
	 * Checks legality of a user's username.
	 * @param username - the username to check
	 * @throws IllegalUsernameLengthException
	 *                        if the username is of an illegal length
	 * @throws IllegalUsernameException
	 *                        if the username is illegal for any other reason
	 */
	private static void checkUsername(String username)
	throws IllegalUsernameException, IllegalUsernameLengthException {
		if (null == username) {
			throw new IllegalUsernameException("username is null");
		}
		if (username.length() < MIN_USERNAME_LENGTH ||
				username.length() > MAX_USERNAME_LENGTH) {
			throw new IllegalUsernameLengthException(MIN_USERNAME_LENGTH, MAX_USERNAME_LENGTH);
		}
		if (!username.matches(LEGAL_USERNAME_REGEX)) {
			throw new IllegalUsernameException("username has illegal characters");
		}
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
