package aig.donations.exceptions;

public class EmptyWaitingListException extends ElementNotFoundException {
  
  public EmptyWaitingListException(String message) {
    super(message);
  }
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
}
