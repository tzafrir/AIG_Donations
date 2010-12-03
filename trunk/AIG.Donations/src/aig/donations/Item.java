package aig.donations;

import java.util.Date;
import java.util.List;

class Item {
//TODO: stub
	static Item retrieveItem(long itemId) {
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

	void setProject(long destinationProjectId) {
	  // TODO Auto-generated method stub
	  
  }

	ItemStatus getStatus() {
	  // TODO Auto-generated method stub
	  return null;
  }

	public static List<Item> retrieveItemsByDonor(String username) {
	  // TODO Auto-generated method stub
	  return null;
  }

	public static void addToDB(String name, String description, long projectId,
      long categoryId, ItemStatus status, Date donationTimestamp, String donorUsername) {
	  // TODO Auto-generated method stub
	  
  }

}
