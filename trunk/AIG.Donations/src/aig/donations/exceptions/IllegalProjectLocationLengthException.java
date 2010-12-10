package aig.donations.exceptions;

public class IllegalProjectLocationLengthException extends IllegalProjectLocationException {
  
  public IllegalProjectLocationLengthException(int min, int max) {
    super("project location length should be between " + min + " and " + max);
  }

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
}
