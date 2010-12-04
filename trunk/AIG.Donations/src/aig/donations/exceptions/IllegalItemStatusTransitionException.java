package aig.donations.exceptions;

public class IllegalItemStatusTransitionException extends Exception {

	public IllegalItemStatusTransitionException(String role, String oldStatus, String newStatus) {
	  super("A " + role + " can't change an item's status from " + 
	  		  oldStatus + " to " + newStatus);
  }

	/**
   * 
   */
  private static final long serialVersionUID = 1L;

}
