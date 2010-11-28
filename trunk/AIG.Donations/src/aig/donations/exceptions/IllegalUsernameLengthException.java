package aig.donations.exceptions;

public class IllegalUsernameLengthException extends IllegalUsernameException {

	public IllegalUsernameLengthException(int min, int max) {
	  super("username length should be between " + min + " and " + max);
  }
	
	
	/**
   * 
   */
  private static final long serialVersionUID = 1L;


}
