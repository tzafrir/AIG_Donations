package aig.donations.exceptions;

public class IllegalPasswordLengthException extends IllegalPasswordException {

	public IllegalPasswordLengthException(int min, int max) {
	  super("password length should be between " + min + " and " + max);
  }
	
	/**
   * 
   */
  private static final long serialVersionUID = 1L;


}
