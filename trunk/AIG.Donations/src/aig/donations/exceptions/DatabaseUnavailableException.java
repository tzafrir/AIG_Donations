/**
 * Exception to be thrown when the database is unavailable.
 *
 * @author Tzafrir Rehan (tzafrir@cs.technion.ac.il)
 */

package aig.donations.exceptions;

public class DatabaseUnavailableException extends Exception {
	public DatabaseUnavailableException(String message) {
	  super(message);
  }

  private static final long serialVersionUID = 1L;
}
