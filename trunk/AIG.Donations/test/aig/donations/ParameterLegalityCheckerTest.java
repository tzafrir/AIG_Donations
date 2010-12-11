package aig.donations;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

import aig.donations.exceptions.*;

public class ParameterLegalityCheckerTest {
  
  ParameterLegalityChecker checker = new ParameterLegalityChecker();
  
 /*
  @Test
  public void testCheckUserName() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testCheckUserRole() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testCheckUserUsername() {
    fail("Not yet implemented");
  }*///TODO- those were checked in UserTest. should they move here?
  
  /*
  @Test
  public void testCheckPassword() {
    fail("Not yet implemented");
  }*///TODO- this was checked in AdministrationTest- move here?
  
  /**** CheckProjectName ****/
  @Test
  public void testCheckProjectNameLegal() {
    checker.checkProjectName("Alice1- it's the best, and we love it.");
  }
  
  @Test (expected = IllegalProjectNameException.class)
  public void testCheckProjectNameNull() {
    checker.checkProjectName(null);
  }
  
  @Test (expected = IllegalProjectNameLengthException.class)
  public void testCheckProjectNameTooShort() {
    checker.checkProjectName("A");
  }
  
  @Test (expected = IllegalProjectNameLengthException.class)
  public void testCheckProjectNameLegalTooLong() {
    checker.checkProjectName("123456789 123456789 123456789 123456789 123456789 .");
  }
  
  @Test (expected = IllegalProjectNameException.class)
  public void testCheckProjectNameIllegalCharacters() {
    checker.checkProjectName("alice!");
  }
  
  /**** CheckProjectDescription ****/
  @Test
  public void testCheckProjectDescriptionLegal() {
    checker.checkProjectDescription("This ia a description 123.-,'");
  }
  
  @Test (expected = IllegalProjectDescriptionException.class)
  public void testCheckProjectDescriptionNull() {
    checker.checkProjectDescription(null);
  }
  
  @Test
  public void testCheckProjectDescriptionEmpty() {
    checker.checkProjectDescription("");
  }
  
  @Test (expected = IllegalProjectDescriptionLengthException.class)
  public void testCheckProjectDescriptionLegalTooLong() {
    checker.checkProjectDescription("123456789 123456789 123456789 123456789 123456789 " + 
        "123456789 123456789 123456789 123456789 123456789 .");
  }
  
  @Test (expected = IllegalProjectDescriptionException.class)
  public void testCheckProjectDescriptionIllegalCharacters() {
    checker.checkProjectDescription("description!");
  }
  
  /**** CheckProjectLocation ****/
  @Test
  public void testCheckProjectLocationLegal() {
    checker.checkProjectLocation("Wonderland- 1st right, then left. That's all");
  }
  
  @Test (expected = IllegalProjectLocationException.class)
  public void testCheckProjectLocationNull() {
    checker.checkProjectLocation(null);
  }
  
  @Test (expected = IllegalProjectLocationLengthException.class)
  public void testCheckProjectLocationTooShort() {
    checker.checkProjectLocation("a");
  }
  
  @Test (expected = IllegalProjectLocationLengthException.class)
  public void testCheckProjectLocationLegalTooLong() {
    checker.checkProjectLocation("123456789 123456789 123456789 123456789 123456789 " + 
        "123456789 123456789 123456789 123456789 123456789 .");
  }
  
  @Test (expected = IllegalProjectLocationException.class)
  public void testCheckProjectLocationIllegalCharacters() {
    checker.checkProjectLocation("Wonderl@nd");
  }
  
  /**** CheckProjectEventTime ****/  
  
  @Test
  public void testCheckProjectEventTimeNow() {
    checker.checkProjectEventTime(new Date());
  }
  
  @Test
  public void testCheckProjectEventTimeFuture() {
    Date date = new Date();
    date.setTime(date.getTime() + 1000);
    checker.checkProjectEventTime(date);
  }
  
  @Test (expected = IllegalProjectEventTimeException.class)
  public void testCheckProjectEventTimeNull() {
    checker.checkProjectEventTime(null);
  }
  
  @Test (expected = IllegalProjectEventTimeException.class)
  public void testCheckProjectEventTimeInThePast() {
    Date date = new Date();
    date.setTime(date.getTime() - 1000);
    checker.checkProjectEventTime(date);
  }
  
  /**** CheckItemName ****/ 
  @Test
  public void testCheckItemNameLegal() {
    checker.checkItemName("Pink table");
  }
  
  @Test (expected = IllegalItemNameException.class)
  public void testCheckItemNameNull() {
    checker.checkItemName(null);
  }
  
  @Test (expected = IllegalItemNameLengthException.class)
  public void testCheckItemNameTooShort() {
    checker.checkItemName("a");
  }
  
  @Test (expected = IllegalItemNameLengthException.class)
  public void testCheckItemNameLegalTooLong() {
    checker.checkItemName("123456789 123456789 123456789 123456789 123456789 .");
  }
  
  @Test (expected = IllegalItemNameException.class)
  public void testCheckPItemNameIllegalCharacters() {
    checker.checkItemName("2 pink tables");
  }
  
  /**** CheckItemDescription ****/
  @Test
  public void testCheckItemDescriptionLegal() {
    checker.checkItemDescription("This ia a description 123.-,'");
  }
  
  @Test (expected = IllegalItemDescriptionException.class)
  public void testCheckItemDescriptionNull() {
    checker.checkItemDescription(null);
  }
  
  @Test
  public void testCheckItemDescriptionEmpty() {
    checker.checkItemDescription("");
  }
  
  @Test (expected = IllegalItemDescriptionLengthException.class)
  public void testCheckItemDescriptionLegalTooLong() {
    checker.checkItemDescription("123456789 123456789 123456789 123456789 123456789 " + 
        "123456789 123456789 123456789 123456789 123456789 .");
  }
  
  @Test (expected = IllegalItemDescriptionException.class)
  public void testCheckItemDescriptionIllegalCharacters() {
    checker.checkItemDescription("description!");
  } 
    
    
  
  /**** CheckCategoryName ****/ 
  @Test
  public void testCheckCategoryNameLegal() {
    checker.checkCategoryName("Pink table");
  }
  
  @Test (expected = IllegalCategoryNameException.class)
  public void testCheckCategoryNameNull() {
    checker.checkCategoryName(null);
  }
  
  @Test (expected = IllegalCategoryNameLengthException.class)
  public void testCheckCategoryNameTooShort() {
    checker.checkCategoryName("a");
  }
  
  @Test (expected = IllegalCategoryNameLengthException.class)
  public void testCheckCategoryNameLegalTooLong() {
    checker.checkCategoryName("123456789 123456789 123456789 123456789 123456789 .");
  }
  
  @Test (expected = IllegalCategoryNameException.class)
  public void testCheckPCategoryNameIllegalCharacters() {
    checker.checkCategoryName("2 pink tables");
  }
  
  /**** CheckCategoryDescription ****/
  @Test
  public void testCheckCategoryDescriptionLegal() {
    checker.checkCategoryDescription("This ia a description 123.-,'");
  }
  
  @Test (expected = IllegalCategoryDescriptionException.class)
  public void testCheckCategoryDescriptionNull() {
    checker.checkCategoryDescription(null);
  }
  
  @Test
  public void testCheckCategoryDescriptionEmpty() {
    checker.checkCategoryDescription("");
  }
  
  @Test (expected = IllegalCategoryDescriptionLengthException.class)
  public void testCheckCategoryDescriptionLegalTooLong() {
    checker.checkCategoryDescription("123456789 123456789 123456789 123456789 123456789 " + 
        "123456789 123456789 123456789 123456789 123456789 .");
  }
  
  @Test (expected = IllegalCategoryDescriptionException.class)
  public void testCheckCategoryDescriptionIllegalCharacters() {
    checker.checkCategoryDescription("description!");
  } 
  
  /**** CheckItemCondition ****/
  
  @Test
  public void testCheckItemConditionLegal() {
    checker.checkItemCondition(ItemCondition.EXCELLENT);
  }
  
  @Test (expected = IllegalItemConditionException.class)
  public void testCheckItemConditionNull() {
    checker.checkItemCondition(null);
  }
  
  /**** CheckThatProjectIsOurs ****/
  
  private class TestProject extends Project {
    public TestProject() {}
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
  
  @Test (expected = IncorrectSocialWorkerException.class)
  public void testCheckThatProjectIsOursBadSocialWorker() throws IncorrectSocialWorkerException {
    checker.checkThatProjectIsOurs(new TestProject(), "bla", Role.SOCIAL_WORKER);
  }
  
  @Test (expected = IncorrectSocialWorkerException.class)
  public void testCheckThatProjectIsOursNotSocialWorker() throws IncorrectSocialWorkerException {
    checker.checkThatProjectIsOurs(new TestProject(), "bla", Role.DONOR);
  }
  
  
  @Test
  public void testCheckCategoryIsntTopLevel() {
    fail("Not yet implemented");
  }//TODO
  
}



