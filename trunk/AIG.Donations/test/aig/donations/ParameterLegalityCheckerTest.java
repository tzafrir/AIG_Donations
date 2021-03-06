package aig.donations;

import java.util.Date;

import org.junit.Test;

import aig.donations.exceptions.*;

public class ParameterLegalityCheckerTest {
  
  ParameterLegalityChecker checker = new ParameterLegalityChecker();
  
  private final static String bigDescription1001Chars =
    "123456789 123456789 123456789 123456789 123456789 " +
    "123456789 123456789 123456789 123456789 123456789 " +
    "123456789 123456789 123456789 123456789 123456789 " +
    "123456789 123456789 123456789 123456789 123456789 " +
    "123456789 123456789 123456789 123456789 123456789 " +
    "123456789 123456789 123456789 123456789 123456789 " +
    "123456789 123456789 123456789 123456789 123456789 " +
    "123456789 123456789 123456789 123456789 123456789 " +
    "123456789 123456789 123456789 123456789 123456789 " +
    "123456789 123456789 123456789 123456789 123456789 " +
    "123456789 123456789 123456789 123456789 123456789 " +
    "123456789 123456789 123456789 123456789 123456789 " +
    "123456789 123456789 123456789 123456789 123456789 " +
    "123456789 123456789 123456789 123456789 123456789 " +
    "123456789 123456789 123456789 123456789 123456789 " +
    "123456789 123456789 123456789 123456789 123456789 " +
    "123456789 123456789 123456789 123456789 123456789 " +
    "123456789 123456789 123456789 123456789 123456789 " +
    "123456789 123456789 123456789 123456789 123456789 " +
    "123456789 123456789 123456789 123456789 123456789 .";
  
  private final static String bigName51Chars =
    "abcdefghi abcdefghi abcdefghi abcdefghi abcdefghi z";
  
  /**** CheckUserName ****/
  @Test
  public void testCheckUserNameLegal() throws IllegalUserNameLengthException,
      IllegalUserNameException {
    checker.checkUserName("Alice the great");
  }
  
  @Test(expected = IllegalUserNameException.class)
  public void testCheckUserNameNull() throws IllegalUserNameLengthException,
      IllegalUserNameException {
    checker.checkUserName(null);
  }
  
  @Test(expected = IllegalUserNameLengthException.class)
  public void testCheckUserNameTooShort() throws IllegalUserNameLengthException,
      IllegalUserNameException {
    checker.checkUserName("A");
  }
  
  @Test(expected = IllegalUserNameLengthException.class)
  public void testCheckUserNameLegalTooLong() throws IllegalUserNameLengthException,
      IllegalUserNameException {
    checker.checkUserName(bigName51Chars);
  }
  
  @Test(expected = IllegalUserNameException.class)
  public void testCheckUserNameIllegalCharacters() throws IllegalUserNameLengthException,
      IllegalUserNameException {
    checker.checkUserName("alice123");
  }
  
  /**** CheckUserRole ****/
  
  @Test
  public void testCheckUserRole() throws IllegalUserRoleException {
    checker.checkUserRole(Role.DONOR);
  }
  
  @Test (expected = IllegalUserRoleException.class)
  public void testCheckUserRoleNull() throws IllegalUserRoleException {
    checker.checkUserRole(null);
  }
  
  
  /**** CheckUserUsername ****/
  @Test
  public void testCheckUserUsernameLegal() throws IllegalUserUsernameLengthException,
      IllegalUserUsernameException {
    checker.checkUserUsername("Alice_1");
  }
  
  @Test(expected = IllegalUserUsernameException.class)
  public void testCheckUserUsernameNull() throws IllegalUserUsernameLengthException,
      IllegalUserUsernameException {
    checker.checkUserUsername(null);
  }
  
  @Test(expected = IllegalUserUsernameLengthException.class)
  public void testCheckUserUsernameTooShort() throws IllegalUserUsernameLengthException,
      IllegalUserUsernameException {
    checker.checkUserUsername("");
  }
  
  @Test(expected = IllegalUserUsernameLengthException.class)
  public void testCheckUserUsernameLegalTooLong() throws IllegalUserUsernameLengthException,
      IllegalUserUsernameException {
    checker.checkUserUsername("aaaaaaaaaabbbbbbbbbbc");
  }
  
  @Test(expected = IllegalUserUsernameException.class)
  public void testCheckUserUsernameIllegalCharacters() throws IllegalUserUsernameLengthException,
      IllegalUserUsernameException {
    checker.checkUserUsername("@lice");
  }
  
  /**** CheckPassword ****/
  @Test
  public void testCheckPasswordLegal() throws IllegalPasswordLengthException,
      IllegalPasswordException {
    checker.checkPassword("sfd78@#$A");
  }
  
  @Test(expected = IllegalPasswordException.class)
  public void testCheckPasswordNull() throws IllegalPasswordLengthException,
      IllegalPasswordException {
    checker.checkPassword(null);
  }
  
  @Test(expected = IllegalPasswordLengthException.class)
  public void testCheckPasswordTooShort() throws IllegalPasswordLengthException,
      IllegalPasswordException {
    checker.checkPassword("abcde");
  }
  
  @Test(expected = IllegalPasswordLengthException.class)
  public void testCheckPasswordLegalTooLong() throws IllegalPasswordLengthException,
      IllegalPasswordException {
    checker.checkPassword("aaaaaaaaaabbbbbbbbbbc");
  }
  
  /**** CheckProjectName ****/
  @Test
  public void testCheckProjectNameLegal() throws IllegalProjectNameLengthException,
      IllegalProjectNameException {
    checker.checkProjectName("Alice1- it's the best, and we love it.");
  }
  
  @Test(expected = IllegalProjectNameException.class)
  public void testCheckProjectNameNull() throws IllegalProjectNameLengthException,
      IllegalProjectNameException {
    checker.checkProjectName(null);
  }
  
  @Test(expected = IllegalProjectNameLengthException.class)
  public void testCheckProjectNameTooShort() throws IllegalProjectNameLengthException,
      IllegalProjectNameException {
    checker.checkProjectName("A");
  }
  
  @Test(expected = IllegalProjectNameLengthException.class)
  public void testCheckProjectNameLegalTooLong() throws IllegalProjectNameLengthException,
      IllegalProjectNameException {
    checker.checkProjectName(bigName51Chars);
  }
  
  @Test(expected = IllegalProjectNameException.class)
  public void testCheckProjectNameIllegalCharacters() throws IllegalProjectNameLengthException,
      IllegalProjectNameException {
    checker.checkProjectName("alice!");
  }
  
  /**** CheckProjectDescription ****/
  @Test
  public void testCheckProjectDescriptionLegal() throws IllegalProjectDescriptionLengthException,
      IllegalProjectDescriptionException {
    checker.checkProjectDescription("This ia a description 123.-,'");
  }
  
  @Test(expected = IllegalProjectDescriptionException.class)
  public void testCheckProjectDescriptionNull() throws IllegalProjectDescriptionLengthException,
      IllegalProjectDescriptionException {
    checker.checkProjectDescription(null);
  }
  
  @Test
  public void testCheckProjectDescriptionEmpty() throws IllegalProjectDescriptionLengthException,
      IllegalProjectDescriptionException {
    checker.checkProjectDescription("");
  }
  
  @Test(expected = IllegalProjectDescriptionLengthException.class)
  public void testCheckProjectDescriptionLegalTooLong()
      throws IllegalProjectDescriptionLengthException, IllegalProjectDescriptionException {
    checker.checkProjectDescription(bigDescription1001Chars);
  }
  
  @Test(expected = IllegalProjectDescriptionException.class)
  public void testCheckProjectDescriptionIllegalCharacters()
      throws IllegalProjectDescriptionLengthException, IllegalProjectDescriptionException {
    checker.checkProjectDescription("description!");
  }
  
  /**** CheckProjectLocation ****/
  @Test
  public void testCheckProjectLocationLegal() throws IllegalProjectLocationLengthException,
      IllegalProjectLocationException {
    checker.checkProjectLocation("Wonderland- 1st right, then left. That's all");
  }
  
  @Test(expected = IllegalProjectLocationException.class)
  public void testCheckProjectLocationNull() throws IllegalProjectLocationLengthException,
      IllegalProjectLocationException {
    checker.checkProjectLocation(null);
  }
  
  @Test(expected = IllegalProjectLocationLengthException.class)
  public void testCheckProjectLocationTooShort() throws IllegalProjectLocationLengthException,
      IllegalProjectLocationException {
    checker.checkProjectLocation("a");
  }
  
  @Test(expected = IllegalProjectLocationLengthException.class)
  public void testCheckProjectLocationLegalTooLong() throws IllegalProjectLocationLengthException,
      IllegalProjectLocationException {
    checker.checkProjectLocation(bigName51Chars);
  }
  
  @Test(expected = IllegalProjectLocationException.class)
  public void testCheckProjectLocationIllegalCharacters()
      throws IllegalProjectLocationLengthException, IllegalProjectLocationException {
    checker.checkProjectLocation("Wonderl@nd");
  }
  
  /**** CheckProjectEventTime ****/
  
  @Test
  public void testCheckProjectEventTimeNow() throws IllegalProjectEventTimeException {
    checker.checkProjectEventTime(new Date());
  }
  
  @Test
  public void testCheckProjectEventTimeFuture() throws IllegalProjectEventTimeException {
    Date date = new Date();
    date.setTime(date.getTime() + 1000);
    checker.checkProjectEventTime(date);
  }
  
  @Test(expected = IllegalProjectEventTimeException.class)
  public void testCheckProjectEventTimeNull() throws IllegalProjectEventTimeException {
    checker.checkProjectEventTime(null);
  }
  
  @Test(expected = IllegalProjectEventTimeException.class)
  public void testCheckProjectEventTimeInThePast() throws IllegalProjectEventTimeException {
    Date date = new Date();
    date.setTime(date.getTime() - 1000);
    checker.checkProjectEventTime(date);
  }
  
  /**** CheckItemName ****/
  @Test
  public void testCheckItemNameLegal() throws IllegalItemNameLengthException,
      IllegalItemNameException {
    checker.checkItemName("Pink table");
  }
  
  @Test(expected = IllegalItemNameException.class)
  public void testCheckItemNameNull() throws IllegalItemNameLengthException,
      IllegalItemNameException {
    checker.checkItemName(null);
  }
  
  @Test(expected = IllegalItemNameLengthException.class)
  public void testCheckItemNameTooShort() throws IllegalItemNameLengthException,
      IllegalItemNameException {
    checker.checkItemName("a");
  }
  
  @Test(expected = IllegalItemNameLengthException.class)
  public void testCheckItemNameLegalTooLong() throws IllegalItemNameLengthException,
      IllegalItemNameException {
    checker.checkItemName(bigName51Chars);
  }
  
  @Test(expected = IllegalItemNameException.class)
  public void testCheckPItemNameIllegalCharacters() throws IllegalItemNameLengthException,
      IllegalItemNameException {
    checker.checkItemName("2 pink tables");
  }
  
  /**** CheckItemDescription ****/
  @Test
  public void testCheckItemDescriptionLegal() throws IllegalItemDescriptionLengthException,
      IllegalItemDescriptionException {
    checker.checkItemDescription("This ia a description 123.-,'");
  }
  
  @Test(expected = IllegalItemDescriptionException.class)
  public void testCheckItemDescriptionNull() throws IllegalItemDescriptionLengthException,
      IllegalItemDescriptionException {
    checker.checkItemDescription(null);
  }
  
  @Test
  public void testCheckItemDescriptionEmpty() throws IllegalItemDescriptionLengthException,
      IllegalItemDescriptionException {
    checker.checkItemDescription("");
  }
  
  @Test(expected = IllegalItemDescriptionLengthException.class)
  public void testCheckItemDescriptionLegalTooLong() throws IllegalItemDescriptionLengthException,
      IllegalItemDescriptionException {
    checker.checkItemDescription(bigDescription1001Chars);
  }
  
  @Test(expected = IllegalItemDescriptionException.class)
  public void testCheckItemDescriptionIllegalCharacters()
      throws IllegalItemDescriptionLengthException, IllegalItemDescriptionException {
    checker.checkItemDescription("description!");
  }
  
  /**** CheckCategoryName ****/
  @Test
  public void testCheckCategoryNameLegal() throws IllegalCategoryNameLengthException,
      IllegalCategoryNameException {
    checker.checkCategoryName("Pink table");
  }
  
  @Test(expected = IllegalCategoryNameException.class)
  public void testCheckCategoryNameNull() throws IllegalCategoryNameLengthException,
      IllegalCategoryNameException {
    checker.checkCategoryName(null);
  }
  
  @Test(expected = IllegalCategoryNameLengthException.class)
  public void testCheckCategoryNameTooShort() throws IllegalCategoryNameLengthException,
      IllegalCategoryNameException {
    checker.checkCategoryName("a");
  }
  
  @Test(expected = IllegalCategoryNameLengthException.class)
  public void testCheckCategoryNameLegalTooLong() throws IllegalCategoryNameLengthException,
      IllegalCategoryNameException {
    checker.checkCategoryName(bigName51Chars);
  }
  
  @Test(expected = IllegalCategoryNameException.class)
  public void testCheckPCategoryNameIllegalCharacters() throws IllegalCategoryNameLengthException,
      IllegalCategoryNameException {
    checker.checkCategoryName("2 pink tables");
  }
  
  /****
   * CheckCategoryDescription
   * 
   * @throws IllegalCategoryDescriptionException
   * @throws IllegalCategoryDescriptionLengthException
   ****/
  @Test
  public void testCheckCategoryDescriptionLegal() throws IllegalCategoryDescriptionLengthException,
      IllegalCategoryDescriptionException {
    checker.checkCategoryDescription("This ia a description 123.-,'");
  }
  
  @Test(expected = IllegalCategoryDescriptionException.class)
  public void testCheckCategoryDescriptionNull() throws IllegalCategoryDescriptionLengthException,
      IllegalCategoryDescriptionException {
    checker.checkCategoryDescription(null);
  }
  
  @Test
  public void testCheckCategoryDescriptionEmpty() throws IllegalCategoryDescriptionLengthException,
      IllegalCategoryDescriptionException {
    checker.checkCategoryDescription("");
  }
  
  @Test(expected = IllegalCategoryDescriptionLengthException.class)
  public void testCheckCategoryDescriptionLegalTooLong()
      throws IllegalCategoryDescriptionLengthException, IllegalCategoryDescriptionException {
    checker.checkCategoryDescription(bigDescription1001Chars);
  }
  
  @Test(expected = IllegalCategoryDescriptionException.class)
  public void testCheckCategoryDescriptionIllegalCharacters()
      throws IllegalCategoryDescriptionLengthException, IllegalCategoryDescriptionException {
    checker.checkCategoryDescription("description!");
  }
  
  /**** CheckItemCondition ****/
  @Test
  public void testCheckItemConditionLegal() throws IllegalItemConditionException {
    checker.checkItemCondition(ItemCondition.EXCELLENT);
  }
  
  @Test(expected = IllegalItemConditionException.class)
  public void testCheckItemConditionNull() throws IllegalItemConditionException {
    checker.checkItemCondition(null);
  }
  
  /**** CheckThatProjectIsOurs ****/
  
  private class TestProject extends Project {
    public TestProject() {
    }
    
    public String getSocialWorkerUsername() {
      return "Moshe";
    }
  }
  
  @Test
  public void testCheckThatProjectIsOursSystemAdmin() throws IncorrectSocialWorkerException {
    checker.checkThatProjectIsOurs(new TestProject(), "bla", Role.SYSTEM_ADMIN);
  }
  
  @Test
  public void testCheckThatProjectIsOursGoodSocialWorker() throws IncorrectSocialWorkerException {
    checker.checkThatProjectIsOurs(new TestProject(), "Moshe", Role.SOCIAL_WORKER);
  }
  
  @Test(expected = IncorrectSocialWorkerException.class)
  public void testCheckThatProjectIsOursBadSocialWorker() throws IncorrectSocialWorkerException {
    checker.checkThatProjectIsOurs(new TestProject(), "bla", Role.SOCIAL_WORKER);
  }
  
  @Test(expected = IncorrectSocialWorkerException.class)
  public void testCheckThatProjectIsOursNotSocialWorker() throws IncorrectSocialWorkerException {
    checker.checkThatProjectIsOurs(new TestProject(), "bla", Role.DONOR);
  }
  
  @Test(expected = CategoryIsTopLevelException.class)
  public void testCheckCategoryIsntTopLevelRoot() throws CategoryIsTopLevelException,
      CategoryNotFoundException {
    checker.checkCategoryIsntTopLevel(-1);
  }
  
  @Test(expected = CategoryIsTopLevelException.class)
  public void testCheckCategoryIsntTopLevelChildOfRoot() throws CategoryNotFoundException,
      CategoryIsTopLevelException {
    CategoryDatabaseGateway gateway = new CategoryDatabaseGatewayStub();
    long id = gateway.addToDB("name1", "d1", -1);
    checker.checkCategoryIsntTopLevel(id, gateway);
  }
  
  @Test
  public void testCheckCategoryIsntTopLevelGrandchildOfRoot() throws CategoryNotFoundException,
      CategoryIsTopLevelException {
    CategoryDatabaseGateway gateway = new CategoryDatabaseGatewayStub();
    long id1 = gateway.addToDB("name1", "d1", -1);
    long id2 = gateway.addToDB("name2", "d2", id1);
    checker.checkCategoryIsntTopLevel(id2, gateway);
  }
  
  private class CategoryDatabaseGatewayStub implements CategoryDatabaseGateway {
    
    private int lastId = 1;
    
    @Override
    public Category retrieveCategory(long categoryId) throws CategoryNotFoundException {
      Category $ = new Category(categoryId);
      $.setParentId((categoryId == 1) ? -1 : categoryId - 1);
      return $;
    }
    
    @Override
    public long addToDB(String name, String description, long parentId) {
      return lastId++;
    }
    
  }
}
