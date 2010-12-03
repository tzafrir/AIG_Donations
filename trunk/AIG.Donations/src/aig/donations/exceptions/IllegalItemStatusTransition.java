package aig.donations.exceptions;

public class IllegalItemStatusTransition extends Exception {

	public IllegalItemStatusTransition(String oldStatus, String newStatus) {
	  super("an item's status can't change from " + 
	  		  oldStatus + " to " + newStatus);
  }

	/**
   * 
   */
  private static final long serialVersionUID = 1L;

}
