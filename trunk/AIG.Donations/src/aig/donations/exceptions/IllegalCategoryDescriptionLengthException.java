package aig.donations.exceptions;

public class IllegalCategoryDescriptionLengthException extends IllegalCategoryDescriptionException {
  
  public IllegalCategoryDescriptionLengthException(int min, int max) {
    super("category description should be between " + min + " and " + max);
  }

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
}
