package aig.donations.exceptions;

public class IllegalItemNameLengthException extends IllegalItemNameException {
  
  public IllegalItemNameLengthException(int min, int max) {
    super("item name should be between " + min + " and " + max);
  }

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
}
