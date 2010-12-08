/**
 * Interface for managing the Category database, regardless of the DBMS in use.
 *
 * @author Tzafrir Rehan (tzafrir@cs.technion.ac.il)
 */

package aig.donations;

import aig.donations.exceptions.CategoryNotFoundException;
import aig.donations.exceptions.DatabaseUnavailableException;

public interface CategoryDatabaseGateway {
  /**
   * Retrieves a category from the database.
   *
   * @param categoryId The ID of the requested Category.
   * @return A Category instance matching the entry in the database with id categoryId.
   * @throws CategoryNotFoundException when a Category with ID categoryId is not found in the
   * database.
   */
  Category retrieveCategory(long categoryId) throws CategoryNotFoundException;

  /**
   * Adds a Category with the given state to the database.
   *
   * @param name The name.
   * @param description The description.
   * @param parentId The ID of the category's parent.
   * @return The ID of the new category.
   */
  long addToDB(String name, String description, long parentId);
}
