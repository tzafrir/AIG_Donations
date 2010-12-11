package aig.donations;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

import aig.donations.exceptions.*;

public class ParameterLegalityCheckerTest {
  
  ParameterLegalityChecker checker = new ParameterLegalityChecker();
  
  /*
   * @Test public void testCheckUserName() { fail("Not yet implemented"); }
   * 
   * @Test public void testCheckUserRole() { fail("Not yet implemented"); }
   * 
   * @Test public void testCheckUserUsername() { fail("Not yet implemented"); }
   */// TODO- those were checked in UserTest. should they move here?
  
  /*
   * @Test public void testCheckPassword() { fail("Not yet implemented"); }
   */// TODO- this was checked in AdministrationTest- move here?
  
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
    checker.checkProjectName("123456789 123456789 123456789 123456789 123456789 .");
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
    checker.checkProjectDescription("123456789 123456789 123456789 123456789 123456789 "
        + "123456789 123456789 123456789 123456789 123456789 .");
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
    checker.checkProjectLocation("123456789 123456789 123456789 123456789 123456789 "
        + "123456789 123456789 123456789 123456789 123456789 .");
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
    checker.checkItemName("123456789 123456789 123456789 123456789 123456789 .");
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
    checker.checkItemDescription("123456789 123456789 123456789 123456789 123456789 "
        + "123456789 123456789 123456789 123456789 123456789 .");
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
    checker.checkCategoryName("123456789 123456789 123456789 123456789 123456789 .");
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
    checker.checkCategoryDescription("123456789 123456789 123456789 123456789 123456789 "
        + "123456789 123456789 123456789 123456789 123456789 .");
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
  public void testCheckCategoryIsntTopLevelChildOfRoot() {
    fail("Not yet implemented");
    // add a category whose father is -1, call with it
  }// TODO
  
  @Test
  public void testCheckCategoryIsntTopLevelGrandchildOfRoot() {
    fail("Not yet implemented");
    // add a category whose grandfather is -1, call with it
  }// TODO
  
}
