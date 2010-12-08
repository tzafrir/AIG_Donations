/**
 * Interface for managing the Category database, regardless of the DBMS in use.
 *
 * @author Tzafrir Rehan (tzafrir@cs.technion.ac.il)
 */

package aig.donations;

import aig.donations.exceptions.CategoryNotFoundException;
import aig.donations.exceptions.DatabaseUnavailableException;

public interface CategoryDatabaseGateway {
  Category retrieveCategory(long categoryId) throws CategoryNotFoundException;
  long addToDB(String name, String description, long parentId);
}
