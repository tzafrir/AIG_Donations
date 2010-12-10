package aig.donations.exceptions;

public class IllegalProjectDescriptionLengthException extends IllegalProjectDescriptionException {
  
  public IllegalProjectDescriptionLengthException(int min, int max) {
    super("project description should be between " + min + " and " + max);
  }

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
}
