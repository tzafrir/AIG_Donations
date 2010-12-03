/**
 * Interface for managing the Category database, regardless of the DBMS in use.
 *
 * @author Tzafrir Rehan (tzafrir@cs.technion.ac.il)
 */

package aig.donations;

public interface CategoryDatabaseGateway {
  Category fetchCategory(long categoryId);
  long insertCategory(String name, String description, long parentId);
}
