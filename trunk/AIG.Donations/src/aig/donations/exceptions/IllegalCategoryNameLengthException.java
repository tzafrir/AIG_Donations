package aig.donations.exceptions;

public class IllegalCategoryNameLengthException extends IllegalCategoryNameException {
  
  public IllegalCategoryNameLengthException(int min, int max) {
    super("category name should be between " + min + " and " + max);
  }

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
}
