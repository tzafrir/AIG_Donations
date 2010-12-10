package aig.donations.exceptions;

public class IllegalItemDescriptionLengthException extends IllegalItemDescriptionException {
  
  public IllegalItemDescriptionLengthException(int min, int max) {
    super("item description should be between " + min + " and " + max);
  }

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
}
