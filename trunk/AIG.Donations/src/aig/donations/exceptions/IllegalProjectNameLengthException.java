package aig.donations.exceptions;

public class IllegalProjectNameLengthException extends IllegalProjectNameException {
  
  public IllegalProjectNameLengthException(int min, int max) {
    super("project name should be between " + min + " and " + max);
  }

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
}
