/**
 * A class that manages the data of a single item, and handles the category database.
 *
 * @author Tzafrir Rehan (tzafrir@cs.technion.ac.il)
 */

package aig.donations;

import java.util.Date;
import java.util.List;

import aig.donations.exceptions.ItemNotFoundException;

public class Item {
  public Item() {
  }

	Item retrieveItem(long itemId) throws ItemNotFoundException {
	  // TODO Auto-generated method stub
	  return null;
  }

	void setStatus(ItemStatus newStatus) {
	  // TODO Auto-generated method stub
  }

	Project getProject() {
	  // TODO Auto-generated method stub
	  return null;
  }

	void setProject(long newProjectId) {
	  // TODO Auto-generated method stub
  }

	ItemStatus getStatus() {
	  // TODO Auto-generated method stub
	  return null;
  }

	static List<Item> retrieveItemsByDonor(String username) {
	  // TODO Auto-generated method stub
	  return null;
  }

	void addToDB(String name, String description, long projectId,
      long categoryId, ItemStatus status, Date donationTimestamp, String donorUsername) {
	  // TODO Auto-generated method stub
  }

	Category getCategory() {
	  // TODO Auto-generated method stub
	  return null;
  }

	void setCategory(long newCategoryId) {
	  // TODO Auto-generated method stub

  }

}
