package aig.donations;

import java.util.Date;
import java.util.List;

class ReceivedItem extends Item {

	ReceivedItem(Item itemToBeReceived) {
	  // TODO Auto-generated constructor stub
		//TODO: creates a ReceivedItem from an item (with the same properties...)
  }

	static ReceivedItem retrieveItem(long itemId) {
	  // TODO Auto-generated method stub
	  return null;
  }
	
	static List<ReceivedItem> retrieveItemsByReceiver(String username) {
	  // TODO Auto-generated method stub
	  return null;
  }

	String getReceiverUsername() {
	  // TODO Auto-generated method stub
	  return null;
  }

	void setReceiverUsername(String newUsername) {
	  // TODO Auto-generated method stub
	  
  }

	void setReceptionTimestamp(Date date) {
	  // TODO Auto-generated method stub
	  
  }

}
