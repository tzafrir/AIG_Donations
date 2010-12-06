package aig.donations;

import java.util.Date;

import aig.donations.exceptions.IllegalNameException;
import aig.donations.exceptions.IllegalNameLengthException;
import aig.donations.exceptions.IllegalRoleException;
import aig.donations.exceptions.IllegalUsernameException;
import aig.donations.exceptions.IllegalUsernameLengthException;

public class ParameterLegalityChecker {

  //length limitations on the users' fields
	protected final int MAX_USERNAME_LENGTH = 20; 
	protected final int MIN_USERNAME_LENGTH = 1; 
	protected final int MAX_USERS_NAME_LENGTH = 50;
	protected final int MIN_USERS_NAME_LENGTH = 2;
	
	//structural limitations on the users' fields
	protected final String LEGAL_USERNAME_REGEX = "[a-zA-Z_0-9]*";
	protected final String LEGAL_USERS_NAME_REGEX = "[a-zA-Z ]*";
	
	/**
	 * Checks legality of a user's real name.
	 * @param name - the name to check
	 * @throws IllegalNameLengthException if the name is of an illegal length
	 * @throws IllegalNameException if the name is illegal for any other reason
	 */
	void checkUserName(String name)
	throws IllegalNameException, IllegalNameLengthException {
		if (null == name) {
			throw new IllegalNameException("name is null");
		}
		if (name.length() < MIN_USERS_NAME_LENGTH ||
				name.length() > MAX_USERS_NAME_LENGTH) {
			throw new IllegalNameLengthException(MIN_USERS_NAME_LENGTH, MAX_USERS_NAME_LENGTH);
		}
		if (!name.matches(LEGAL_USERS_NAME_REGEX)) {
			throw new IllegalNameException("name has illegal characters");
		}
	}

	/**
	 * Checks legality of a user's role.
	 * @param role - the role to check
	 * @throws IllegalRoleException if the role is illegal
	 */
	void checkUserRole(Role role) throws IllegalRoleException {
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
	void checkUserUsername(String username)
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

	void checkProjectName(String name) {
	  // TODO Auto-generated method stub
	  
  }

	void checkProjectDescription(String description) {
	  // TODO Auto-generated method stub
	  
  }

	void checkProjectLocation(String location) {
	  // TODO Auto-generated method stub
	  
  }

	void checkProjectEventTime(Date eventTime) {
	  // TODO Auto-generated method stub
	  //TODO: check if null. check if in the past?
  }

	void checkItemName(String itemName) {
	  // TODO Auto-generated method stub
	  
  }

	void checkItemDescription(String itemDescription) {
	  // TODO Auto-generated method stub
	  
  }

	void checkCategoryName(String name) {
	  // TODO Auto-generated method stub
	  
  }

	void checkCategoryDescription(String name) {
	  // TODO Auto-generated method stub
	  
  }

}
