package aig.donations;

import java.util.Date;

import aig.donations.exceptions.CategoryIsTopLevelException;
import aig.donations.exceptions.CategoryNotFoundException;
import aig.donations.exceptions.IllegalCategoryDescriptionException;
import aig.donations.exceptions.IllegalCategoryDescriptionLengthException;
import aig.donations.exceptions.IllegalCategoryNameException;
import aig.donations.exceptions.IllegalCategoryNameLengthException;
import aig.donations.exceptions.IllegalItemConditionException;
import aig.donations.exceptions.IllegalItemDescriptionException;
import aig.donations.exceptions.IllegalItemDescriptionLengthException;
import aig.donations.exceptions.IllegalItemNameException;
import aig.donations.exceptions.IllegalItemNameLengthException;
import aig.donations.exceptions.IllegalParameterException;
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
  protected final int    maxUserUsernameLength         = 20;
  protected final int    minUserUsernameLength         = 1;
  protected final int    maxUserNameLength             = 50;
  protected final int    minUserNameLength             = 2;
  protected final int    maxPasswordLength             = 20;
  protected final int    minPasswordLength             = 6;
  protected final int    maxProjectNameLength          = 50;
  protected final int    minProjectNameLength          = 2;
  protected final int    maxProjectDescriptionLength   = 100;
  protected final int    minProjectDescriptionLength   = 0;
  protected final int    maxProjectLocationLength      = 100;
  protected final int    minProjectLocationLength      = 2;
  protected final int    maxItemNameLength             = 50;
  protected final int    minItemNameLength             = 2;
  protected final int    maxItemDescriptionLength      = 100;
  protected final int    minItemDescriptionLength      = 0;
  protected final int    maxCategoryNameLength         = 50;
  protected final int    minCategoryNameLength         = 2;
  protected final int    maxCategoryDescriptionLength  = 100;
  protected final int    minCategoryDescriptionLength  = 0;
  
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
    try {
      checkString(name, minUserNameLength, maxUserNameLength, legalUserNameRegex,
          new IllegalUserNameException("user name is null"), new IllegalUserNameLengthException(
              minUserNameLength, maxUserNameLength), new IllegalUserNameException(
              "user name has illegal characters"));
    } catch (IllegalUserNameException e) {
      throw e;
    } catch (IllegalParameterException e) {
      throw new AssertionError(e);
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
    try {
      checkString(username, minUserUsernameLength, maxUserUsernameLength, legalUserUsernameRegex,
          new IllegalUserUsernameException("username is null"),
          new IllegalUserUsernameLengthException(minUserUsernameLength, maxUserUsernameLength),
          new IllegalUserUsernameException("username has illegal characters"));
    } catch (IllegalUserUsernameException e) {
      throw e;
    } catch (IllegalParameterException e) {
      throw new AssertionError(e);
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
    try {
      checkString(name, minProjectNameLength, maxProjectNameLength, legalProjectNameRegex,
          new IllegalProjectNameException("project name is null"),
          new IllegalProjectNameLengthException(minProjectNameLength, maxProjectNameLength),
          new IllegalProjectNameException("project name has illegal characters"));
    } catch (IllegalProjectNameException e) {
      throw e;
    } catch (IllegalParameterException e) {
      throw new AssertionError(e);
    }
  }
  
  void checkProjectDescription(String description) throws IllegalProjectDescriptionException,
      IllegalProjectDescriptionLengthException {
    try {
      checkString(description, minProjectDescriptionLength, maxProjectDescriptionLength,
          legalProjectDescriptionRegex, new IllegalProjectDescriptionException(
              "project description is null"), new IllegalProjectDescriptionLengthException(
              minProjectDescriptionLength, maxProjectDescriptionLength),
          new IllegalProjectDescriptionException("project description has illegal characters"));
    } catch (IllegalProjectDescriptionException e) {
      throw e;
    } catch (IllegalParameterException e) {
      throw new AssertionError(e);
    }
  }
  
  void checkProjectLocation(String location) throws IllegalProjectLocationException,
      IllegalProjectLocationLengthException {
    try {
      checkString(location, minProjectLocationLength, maxProjectLocationLength,
          legalProjectLocationRegex,
          new IllegalProjectLocationException("project location is null"),
          new IllegalProjectLocationLengthException(minProjectLocationLength,
              maxProjectLocationLength), new IllegalProjectLocationException(
              "project location has illegal characters"));
    } catch (IllegalProjectLocationException e) {
      throw e;
    } catch (IllegalParameterException e) {
      throw new AssertionError(e);
    }
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
    try {
      checkString(itemName, minItemNameLength, maxItemNameLength, legalItemNameRegex,
          new IllegalItemNameException("item name is null"), new IllegalItemNameLengthException(
              minItemNameLength, maxItemNameLength), new IllegalItemNameException(
              "item name has illegal characters"));
    } catch (IllegalItemNameException e) {
      throw e;
    } catch (IllegalParameterException e) {
      throw new AssertionError(e);
    }
    
  }
  
  void checkItemDescription(String itemDescription) throws IllegalItemDescriptionException,
      IllegalItemDescriptionLengthException {
    try {
      checkString(itemDescription, minItemDescriptionLength, maxItemDescriptionLength,
          legalItemDescriptionRegex,
          new IllegalItemDescriptionException("item description is null"),
          new IllegalItemDescriptionLengthException(minItemDescriptionLength,
              maxItemDescriptionLength), new IllegalItemDescriptionException(
              "item description has illegal characters"));
    } catch (IllegalItemDescriptionException e) {
      throw e;
    } catch (IllegalParameterException e) {
      throw new AssertionError(e);
    }
    
  }
  
  void checkCategoryName(String name) throws IllegalCategoryNameException,
      IllegalCategoryNameLengthException {
    try {
      checkString(name, minCategoryNameLength, maxCategoryNameLength, legalCategoryNameRegex,
          new IllegalCategoryNameException("category name is null"),
          new IllegalCategoryNameLengthException(minCategoryNameLength, maxCategoryNameLength),
          new IllegalCategoryNameException("category name has illegal characters"));
    } catch (IllegalCategoryNameException e) {
      throw e;
    } catch (IllegalParameterException e) {
      throw new AssertionError(e);
    }
    
  }
  
  void checkCategoryDescription(String description) throws IllegalCategoryDescriptionException,
      IllegalCategoryDescriptionLengthException {
    try {
      checkString(description, minCategoryDescriptionLength, maxCategoryDescriptionLength,
          legalCategoryDescriptionRegex, new IllegalCategoryDescriptionException(
              "category description is null"), new IllegalCategoryDescriptionLengthException(
              minCategoryDescriptionLength, maxCategoryDescriptionLength),
          new IllegalCategoryDescriptionException("category description has illegal characters"));
    } catch (IllegalCategoryDescriptionException e) {
      throw e;
    } catch (IllegalParameterException e) {
      throw new AssertionError(e);
    }
    
  }
  
  void checkItemCondition(ItemCondition itemCondition) throws IllegalItemConditionException {
    if (null == itemCondition) {
      throw new IllegalItemConditionException("Item condition is null");
    }
    
  }
  
  void checkCategoryIsntTopLevel(long categoryId) throws CategoryNotFoundException,
      CategoryIsTopLevelException {
    if (-1 == categoryId
        || -1 == new CategoryDatabaseGatewayImpl().retrieveCategory(categoryId).getParentId()) {
      throw new CategoryIsTopLevelException("The category is a top level category");
    }
  }
  
  void checkThatProjectIsOurs(Project project, String username, Role role)
      throws IncorrectSocialWorkerException {
    if (Role.SYSTEM_ADMIN != role && !username.equals(project.getSocialWorkerUsername())) {
      throw new IncorrectSocialWorkerException("The project does not belong to this social worker");
    }
  }
  
  private void checkString(String str, int minLength, int maxLength, String legalRegex,
      IllegalParameterException nullException, IllegalParameterException illegalLengthException,
      IllegalParameterException illegalCharactersException) throws IllegalParameterException {
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
