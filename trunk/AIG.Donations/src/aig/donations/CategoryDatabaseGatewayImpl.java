/**
 * Concrete implementation of the CategoryDatabaseGateway interface.
 *
 * @author Tzafrir Rehan (tzafrir@cs.technion.ac.il)
 */

package aig.donations;

import aig.donations.exceptions.CategoryNotFoundException;
import aig.donations.exceptions.DatabaseUnavailableException;

public class CategoryDatabaseGatewayImpl implements CategoryDatabaseGateway {
  public Category retrieveCategory(long categoryId) throws CategoryNotFoundException {
    // TODO(tzafrir/vania): implement.
    return null;
  }

  public long addToDB(String name, String description, long parentId) {
    // TODO(tzafrir/vania): implement.
    return 0;
  }
}
