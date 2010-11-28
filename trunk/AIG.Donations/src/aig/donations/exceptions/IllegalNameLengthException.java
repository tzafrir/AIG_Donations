package aig.donations.exceptions;

public class IllegalNameLengthException extends IllegalNameException {


	public IllegalNameLengthException(int min, int max) {
	  super("name length should be between " + min + " and " + max);
  }

	/**
   * 
   */
  private static final long serialVersionUID = 1L;

}
