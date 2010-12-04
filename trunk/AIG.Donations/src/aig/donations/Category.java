/**
 * A class that manages the data of a single category, and handles the category database.
 *
 * @author Tzafrir Rehan (tzafrir@cs.technion.ac.il)
 */

package aig.donations;

import aig.donations.exceptions.CategoryNotFoundException;

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

  /**
   * Retrieves a category from the database.
   *
   * @param categoryId The ID of the requested Category.
   * @return A Category instance matching the entry in the database with id categoryId.
   * @throws CategoryNotFoundException when a Category with ID categoryId is not found in the
   * database.
   */
  Category retrieveCategory(long categoryId) throws CategoryNotFoundException {
    return gateway.fetchCategory(categoryId);
  }

  /**
   * Adds a Category with the given state to the database.
   *
   * @param name The name.
   * @param description The description.
   * @param parentId The ID of the category's parent.
   * @return The ID of the new category.
   */
  long addToDB(String name, String description, long parentId) {
    return gateway.insertCategory(name, description, parentId);
  }

	long getId() {
	  // TODO Auto-generated method stub
	  return 0;
  }
}
