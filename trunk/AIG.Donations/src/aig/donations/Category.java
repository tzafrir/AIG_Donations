/**
 * A class that manages the data of a single category, and handles the category database.
 *
 * @author Tzafrir Rehan (tzafrir@cs.technion.ac.il)
 */

package aig.donations;

import aig.donations.exceptions.CategoryNotFoundException;
import aig.donations.exceptions.DatabaseUnavailableException;

public class Category {
  long id;
  long parentId;
  String name;
  String description;
  CategoryDatabaseGateway gateway;

  static final long INVALID = -1;

  public Category() {
    id = INVALID;
    parentId = INVALID;
    name = null;
    description = null;

    // TODO(tzafrir): gateway = new CategoryDatabaseGatewayImplementation();
  }

  /**
   * Constructor for the database access layer - use whenever ID of the Category is known.
   */
  public Category(long id) {
    this();
    this.id = id;
  }

  /**
   * Testing constructor - Do not use in production code.
   */
  public Category(CategoryDatabaseGateway gateway) {
    this();
    this.gateway = gateway;
  }

  void setName(String newName) {
    name = newName;
  }

  String getName() {
    return name;
  }

  void setDescription(String newDescription) {
    description = newDescription;
  }

  String getDescription() {
    return description;
  }

  void setParentId(long newId) {
    parentId = newId;
  }

  long getParentId() {
    return parentId;
  }

	long getId() {
	  // TODO Auto-generated method stub
	  return 0;
  }

	void removeCategory() {
	  // TODO Auto-generated method stub
	  //TODO: this may also be renamed to removeFromDB, if you think that's better...
  }
}
