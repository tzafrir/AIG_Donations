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
import aig.donations.exceptions.IncorrectSocialWorkerException;

public class ParameterLegalityChecker {
  
  // length limitations on the users' fields
  protected final int    maxUserUsernameLength        = 20;
  protected final int    minUserUsernameLength        = 1;
  protected final int    maxUserNameLength            = 50;
  protected final int    minUserNameLength            = 2;
  protected final int    maxPasswordLength            = 20;
  protected final int    minPasswordLength            = 6;
  protected final int    maxProjectNameLength         = 50;
  protected final int    minProjectNameLength         = 2;
  protected final int    maxProjectDescriptionLength  = 100;
  protected final int    minProjectDescriptionLength  = 0;
  protected final int    maxProjectLocationLength     = 100;
  protected final int    minProjectLocationLength     = 2;
  protected final int    maxItemNameLength            = 50;
  protected final int    minItemNameLength            = 2;
  protected final int    maxItemDescriptionLength     = 100;
  protected final int    minItemDescriptionLength     = 0;
  protected final int    maxCategoryNameLength        = 50;
  protected final int    minCategoryNameLength        = 2;
  protected final int    maxCategoryDescriptionLength = 100;
  protected final int    minCategoryDescriptionLength = 0;
  
  // structural limitations on the users' fields
  protected final String legalUserUsernameRegex        = "[a-zA-Z_0-9]*";
  protected final String legalUserNameRegex            = "[a-zA-Z ]*";
  protected final String legalProjectNameRegex         = "[a-zA-Z0-9 ,'.-]*";
  protected final String legalProjectDescriptionRegex  = "[a-zA-Z0-9 ,'.-]*";
  protected final String legalProjectLocationRegex     = "[a-zA-Z0-9 ,'.-]*";
  protected final String legalCategoryNameRegex        = "[a-zA-Z ]*";
  protected final String legalItemNameRegex            = "[a-zA-Z ]*";
  protected final String legalItemDescriptionRegex     = "[a-zA-Z0-9 ,'.-]*";
  protected final String legalCategoryDescriptionRegex = "[a-zA-Z0-9 ,'.-]*";

  
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
    checkString(name, minUserNameLength, maxUserNameLength, legalUserNameRegex,
        new IllegalUserNameException("user name is null"), 
        new IllegalUserNameLengthException(minUserNameLength, maxUserNameLength),
        new IllegalUserNameException("user name has illegal characters"));
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
    checkString(username, minUserUsernameLength, maxUserUsernameLength, legalUserUsernameRegex,
        new IllegalUserUsernameException("username is null"), 
        new IllegalUserUsernameLengthException(minUserUsernameLength, maxUserUsernameLength),
        new IllegalUserUsernameException("username has illegal characters"));
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
    checkString(name, minProjectNameLength, maxProjectNameLength, legalProjectNameRegex,
        new IllegalProjectNameException("project name is null"), 
        new IllegalProjectNameLengthException(minProjectNameLength, maxProjectNameLength),
        new IllegalProjectNameException("project name has illegal characters"));
  }
  
  void checkProjectDescription(String description) throws IllegalProjectDescriptionException,
      IllegalProjectDescriptionLengthException {
    checkString(description, minProjectDescriptionLength, maxProjectDescriptionLength,
        legalProjectDescriptionRegex,
        new IllegalProjectDescriptionException("project description is null"), 
        new IllegalProjectDescriptionLengthException(minProjectDescriptionLength, maxProjectDescriptionLength),
        new IllegalProjectDescriptionException("project description has illegal characters"));
  }
  
  void checkProjectLocation(String location) throws IllegalProjectLocationException,
      IllegalProjectLocationLengthException {
    checkString(location, minProjectLocationLength, maxProjectLocationLength,
        legalProjectLocationRegex,
        new IllegalProjectLocationException("project location is null"), 
        new IllegalProjectLocationLengthException(minProjectLocationLength, maxProjectLocationLength),
        new IllegalProjectLocationException("project location has illegal characters"));
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
    checkString(itemName, minItemNameLength, maxItemNameLength, legalItemNameRegex,
        new IllegalItemNameException("item name is null"), 
        new IllegalItemNameLengthException(minItemNameLength, maxItemNameLength),
        new IllegalItemNameException("item name has illegal characters"));
    
  }
  
  void checkItemDescription(String itemDescription) throws IllegalItemDescriptionException,
      IllegalItemDescriptionLengthException {
    checkString(itemDescription, minItemDescriptionLength, maxItemDescriptionLength,
        legalItemDescriptionRegex,
        new IllegalItemDescriptionException("item description is null"), 
        new IllegalItemDescriptionLengthException(minItemDescriptionLength, maxItemDescriptionLength),
        new IllegalItemDescriptionException("item description has illegal characters"));
    
  }
  
  void checkCategoryName(String name) throws IllegalCategoryNameException,
      IllegalCategoryNameLengthException {
    checkString(name, minCategoryNameLength, maxCategoryNameLength, legalCategoryNameRegex,
        new IllegalCategoryNameException("category name is null"), 
        new IllegalCategoryNameLengthException(minCategoryNameLength, maxCategoryNameLength),
        new IllegalCategoryNameException("category name has illegal characters"));
    
  }
  
  void checkCategoryDescription(String description) throws IllegalCategoryDescriptionException,
      IllegalCategoryDescriptionLengthException {
    checkString(description, minCategoryDescriptionLength, maxCategoryDescriptionLength,
        legalCategoryDescriptionRegex,
        new IllegalCategoryDescriptionException("category description is null"), 
        new IllegalCategoryDescriptionLengthException(minCategoryDescriptionLength,
            maxCategoryDescriptionLength),
        new IllegalCategoryDescriptionException("category description has illegal characters"));
    
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
  
  private void checkString(String str, int minLength, int maxLength,
      String legalRegex, IllegalArgumentException nullException,
      IllegalArgumentException illegalLengthException,
      IllegalArgumentException illegalCharactersException) throws IllegalArgumentException {
    if (null == str) {
      throw nullException;
    }
    if (str.length() < minLength || str.length() > maxLength) {
      throw illegalLengthException;
    }
    if (!str.matches(legalRegex)) {
      throw illegalCharactersException;
    }
  }
  
}
