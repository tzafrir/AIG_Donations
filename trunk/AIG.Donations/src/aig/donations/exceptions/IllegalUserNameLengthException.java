package aig.donations.exceptions;

public class IllegalUserNameLengthException extends IllegalUserNameException {


	public IllegalUserNameLengthException(int min, int max) {
	  super("name length should be between " + min + " and " + max);
  }

	/**
   * 
   */
  private static final long serialVersionUID = 1L;

}
