package aig.donations;

import java.util.Date;
import java.util.List;

class ReceivedItem extends Item {
  
  ReceivedItem(Item itemToBeReceived) {
    // TODO Auto-generated constructor stub
    // TODO: creates a ReceivedItem from an item (with the same properties...)
  }
  
  static ReceivedItem retrieveItem(long itemId) {
    // TODO Auto-generated method stub
    return null;
  }
  
  static List<ReceivedItem> retrieveReceivedItemsByReceiver(String username) {
    // TODO Auto-generated method stub
    // TODO: return only the ones with status RECEIVED
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
  
  static List<ReceivedItem> retrieveMatchedItemsByReceiver(String username) {
    // TODO Auto-generated method stub
    // TODO: return only the ones with status MATCHED
    return null;
  }
  
  static List<Pair<Project, Category>> retrieveWaitingDataByReceiver(String username) {
    // TODO Auto-generated method stub
    // TODO: return a list of pairs, where each pair of project+category
    // represents that 'username' is waiting in the waiting queue for that
    // category in that project.
    return null;
  }
  
}
