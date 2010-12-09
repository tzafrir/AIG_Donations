package aig.donations;

import java.util.Date;

import aig.donations.exceptions.IllegalCategoryDescriptionException;
import aig.donations.exceptions.IllegalCategoryDescriptionLengthException;
import aig.donations.exceptions.IllegalCategoryNameException;
import aig.donations.exceptions.IllegalCategoryNameLengthException;
import aig.donations.exceptions.IllegalItemConditionException;
import aig.donations.exceptions.IllegalItemDescriptionException;
import aig.donations.exceptions.IllegalItemDescriptionLengthException;
import aig.donations.exceptions.IllegalItemNameException;
import aig.donations.exceptions.IllegalItemNameLengthException;
import aig.donations.exceptions.IllegalPasswordException;
import aig.donations.exceptions.IllegalPasswordLengthException;
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
import aig.donations.exceptions.CategoryIsTopLevelException;
import aig.donations.exceptions.IncorrectSocialWorkerException;

public class ParameterLegalityChecker {
  
  // length limitations on the users' fields
  protected final int    maxUserUsernameLength  = 20;
  protected final int    minUserUsernameLength  = 1;
  protected final int    maxUserNameLength      = 50;
  protected final int    minUserNameLength      = 2;
  protected final int    minPasswordLength      = 6;
  protected final int    maxPasswordLength      = 20;
  
  // structural limitations on the users' fields
  protected final String legalUserUsernameRegex = "[a-zA-Z_0-9]*";
  protected final String legalUserNameRegex     = "[a-zA-Z ]*";
  
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
    if (name.length() < minUserNameLength || name.length() > maxUserNameLength) {
      throw new IllegalUserNameLengthException(minUserNameLength, maxUserNameLength);
    }
    if (!name.matches(legalUserNameRegex)) {
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
    if (username.length() < minUserUsernameLength || username.length() > maxUserUsernameLength) {
      throw new IllegalUserUsernameLengthException(minUserUsernameLength, maxUserUsernameLength);
    }
    if (!username.matches(legalUserUsernameRegex)) {
      throw new IllegalUserUsernameException("username has illegal characters");
    }
  }
  
  void checkPassword(String password) throws IllegalPasswordException,
      IllegalPasswordLengthException {
    if (null == password) {
      throw new IllegalPasswordException("password is null");
    }
    
    if (password.length() < minPasswordLength || password.length() > maxPasswordLength) {
      throw new IllegalPasswordLengthException(minPasswordLength, maxPasswordLength);
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
    if (null == eventTime) {
      throw new IllegalProjectEventTimeException("Project event time is null");
    }
    if (eventTime.before(new Date())) {
      throw new IllegalProjectEventTimeException("Project event time is in the past");
    }
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
  
  void checkItemCondition(ItemCondition itemCondition) throws IllegalItemConditionException {
    if (null == itemCondition) {
      throw new IllegalItemConditionException("Item condition is null");
    }
    
  }
  
  void checkCategoryIsntTopLevel(long categoryId) {
    /*
     * if (-1 == categoryId || -1 ==
     * Category.retrieveCategory(categoryId).getParentId()) { throw new
     * categoryIsTopLevelException("The category is a top level category"); }
     */
    // TODO: fix that code for static/non-static stuff...
    
  }
  
  void checkThatProjectIsOurs(Project project, String username, Role role)
      throws IncorrectSocialWorkerException {
    if (!username.equals(project.getSocialWorkerUsername()) && Role.SYSTEM_ADMIN != role) {
      throw new IncorrectSocialWorkerException("The project does not belong to this social worker");
    }
    
  }
}
