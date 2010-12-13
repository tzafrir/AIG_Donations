package aig.donations;

import java.util.Date;
import java.util.List;

import aig.donations.exceptions.EmptyWaitingListException;
import aig.donations.exceptions.NoPendingItemsException;
import aig.donations.exceptions.ProjectNotFoundException;
import aig.donations.exceptions.UserNotInWaitingListException;

class Project {
  void setName(String newName) {
    // TODO Auto-generated method stub
    
  }
  
  void setDescription(String newDescription) {
    // TODO Auto-generated method stub
    
  }
  
  void setLocation(String newLocation) {
    // TODO Auto-generated method stub
    
  }
  
  void setEventTime(Date newEventTime) {
    // TODO Auto-generated method stub
    
  }
  
  void addCategory(long categoryId) {
    // TODO Auto-generated method stub
    // TODO: if (hasCategory(categoryId)) {return;} --> to make adding a whole
    // sub-tree (with add all) not throw a million times
  }
  
  long getId() {
    // TODO Auto-generated method stub
    return 0;
  }
  
  boolean isClosed() {
    // TODO Auto-generated method stub
    return false;
  }
  
  boolean hasCategory(long categoryId) {
    // TODO Auto-generated method stub
    return false;
  }
  
  Item getPendingItem(long categoryId) throws NoPendingItemsException {
    // TODO Auto-generated method stub
    // TODO: this method should do the tree traversing (downwards) to find an
    // item (I think the first one found should do nicely)
    // since it is done much easier and more efficient in an SQL query
    return null;
  }
  
  List<Item> getAllItems() {
    // TODO Auto-generated method stub
    return null;
  }
  
  List<ReceivedItem> getReceivedItems() {
    // TODO Auto-generated method stub
    return null;
  }
  
  List<Item> getUnreceivedItems() {
    // TODO Auto-generated method stub
    return null;
  }
  
  String getSocialWorkerUsername() {
    // TODO Auto-generated method stub
    return null;
  }
  
}
