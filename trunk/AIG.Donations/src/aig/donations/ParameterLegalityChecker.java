package aig.donations;

import java.util.Date;

import aig.donations.exceptions.IllegalCategoryDescriptionException;
import aig.donations.exceptions.IllegalCategoryDescriptionLengthException;
import aig.donations.exceptions.IllegalCategoryNameException;
import aig.donations.exceptions.IllegalCategoryNameLengthException;
import aig.donations.exceptions.IllegalItemDescriptionException;
import aig.donations.exceptions.IllegalItemDescriptionLengthException;
import aig.donations.exceptions.IllegalItemNameException;
import aig.donations.exceptions.IllegalItemNameLengthException;
import aig.donations.exceptions.IllegalProjectDescriptionException;
import aig.donations.exceptions.IllegalProjectDescriptionLengthException;
import aig.donations.exceptions.IllegalProjectEventTimeException;
import aig.donations.exceptions.IllegalProjectLocationException;
import aig.donations.exceptions.IllegalProjectLocationLengthException;
import aig.donations.exceptions.IllegalProjectNameException;
import aig.donations.exceptions.IllegalProjectNameLengthException;
import aig.donations.exceptions.IllegalUserNameException;
import aig.donations.exceptions.IllegalUserNameLengthException;
import aig.donations.exceptions.IllegalUserRoleException;
import aig.donations.exceptions.IllegalUserUsernameException;
import aig.donations.exceptions.IllegalUserUsernameLengthException;

public class ParameterLegalityChecker {
  
  // length limitations on the users' fields
  protected final int    MAX_USERNAME_LENGTH    = 20;
  protected final int    MIN_USERNAME_LENGTH    = 1;
  protected final int    MAX_USERS_NAME_LENGTH  = 50;
  protected final int    MIN_USERS_NAME_LENGTH  = 2;
  
  // structural limitations on the users' fields
  protected final String LEGAL_USERNAME_REGEX   = "[a-zA-Z_0-9]*";
  protected final String LEGAL_USERS_NAME_REGEX = "[a-zA-Z ]*";
  
  /**
   * Checks legality of a user's real name.
   * 
   * @param name
   *          - the name to check
   * @throws IllegalUserNameLengthException
   *           if the name is of an illegal length
   * @throws IllegalUserNameException
   *           if the name is illegal for any other reason
   */
  void checkUserName(String name) throws IllegalUserNameException, IllegalUserNameLengthException {
    if (null == name) {
      throw new IllegalUserNameException("name is null");
    }
    if (name.length() < MIN_USERS_NAME_LENGTH || name.length() > MAX_USERS_NAME_LENGTH) {
      throw new IllegalUserNameLengthException(MIN_USERS_NAME_LENGTH, MAX_USERS_NAME_LENGTH);
    }
    if (!name.matches(LEGAL_USERS_NAME_REGEX)) {
      throw new IllegalUserNameException("name has illegal characters");
    }
  }
  
  /**
   * Checks legality of a user's role.
   * 
   * @param role
   *          - the role to check
   * @throws IllegalUserRoleException
   *           if the role is illegal
   */
  void checkUserRole(Role role) throws IllegalUserRoleException {
    if (null == role) {
      throw new IllegalUserRoleException("role is null");
    }
  }
  
  /**
   * Checks legality of a user's username.
   * 
   * @param username
   *          - the username to check
   * @throws IllegalUserUsernameLengthException
   *           if the username is of an illegal length
   * @throws IllegalUserUsernameException
   *           if the username is illegal for any other reason
   */
  void checkUserUsername(String username) throws IllegalUserUsernameException,
      IllegalUserUsernameLengthException {
    if (null == username) {
      throw new IllegalUserUsernameException("username is null");
    }
    if (username.length() < MIN_USERNAME_LENGTH || username.length() > MAX_USERNAME_LENGTH) {
      throw new IllegalUserUsernameLengthException(MIN_USERNAME_LENGTH, MAX_USERNAME_LENGTH);
    }
    if (!username.matches(LEGAL_USERNAME_REGEX)) {
      throw new IllegalUserUsernameException("username has illegal characters");
    }
  }
  
  void checkProjectName(String name) throws IllegalProjectNameException,
      IllegalProjectNameLengthException {
    // TODO Auto-generated method stub
    
  }
  
  void checkProjectDescription(String description) throws IllegalProjectDescriptionException,
      IllegalProjectDescriptionLengthException {
    // TODO Auto-generated method stub
    
  }
  
  void checkProjectLocation(String location) throws IllegalProjectLocationException,
      IllegalProjectLocationLengthException {
    // TODO Auto-generated method stub
    
  }
  
  void checkProjectEventTime(Date eventTime) throws IllegalProjectEventTimeException {
    // TODO Auto-generated method stub
    // TODO: check if null. check if in the past?
  }
  
  void checkItemName(String itemName) throws IllegalItemNameException,
      IllegalItemNameLengthException {
    // TODO Auto-generated method stub
    
  }
  
  void checkItemDescription(String itemDescription) throws IllegalItemDescriptionException,
      IllegalItemDescriptionLengthException {
    // TODO Auto-generated method stub
    
  }
  
  void checkCategoryName(String name) throws IllegalCategoryNameException,
      IllegalCategoryNameLengthException {
    // TODO Auto-generated method stub
    
  }
  
  void checkCategoryDescription(String name) throws IllegalCategoryDescriptionException,
      IllegalCategoryDescriptionLengthException {
    // TODO Auto-generated method stub
    
  }
  
}
