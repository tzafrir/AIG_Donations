package aig.donations.exceptions;

public class IncompatiblePrivilegesException extends Exception {
  
  public IncompatiblePrivilegesException(String activityType) {
    super("user cannot perform " + activityType + " activities");
  }
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
}
