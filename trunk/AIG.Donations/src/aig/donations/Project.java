package aig.donations;

import java.util.Date;
import java.util.List;

import aig.donations.exceptions.EmptyWaitingListException;
import aig.donations.exceptions.NoPendingItemsException;
import aig.donations.exceptions.ProjectNotFoundException;
import aig.donations.exceptions.UserNotInWaitingListException;

class Project {
  // TODO: stub
  static Project retrieveProject(long projectId) throws ProjectNotFoundException {
    // TODO Auto-generated method stub
    return null;
  }
  
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
  
  static long addToDB(String name, String description, String location, Date eventTime,
      String socialWorkerUsername) {
    // TODO Auto-generated method stub
    // TODO: should return the id generated for this project
    return 0;
  }
  
  static void addToWaitingQueue(long projectId, long categoryId, String username) {
    // TODO Auto-generated method stub
  }
  
  boolean hasCategory(long categoryId) {
    // TODO Auto-generated method stub
    return false;
  }
  
  static void removeUserFromWaitingQueue(long projectId, long categoryId, String username)
      throws UserNotInWaitingListException {
    // TODO Auto-generated method stub
    // TODO: removes the user 'username' from the queue, throws if it isn't
    // there.
    // TODO: if a user can request twice from a category - does this remove 1
    // request or all requests from this category?
  }
  
  Item getPendingItem(long categoryId) throws NoPendingItemsException {
    // TODO Auto-generated method stub
    // TODO: this method should do the tree traversing (downwards) to find an
    // item (I think the first one found should do nicely)
    // since it is done much easier and more efficient in an SQL query
    return null;
  }
  
  static String removeFirstFromWaitingQueue(long projectId, long categoryId)
      throws EmptyWaitingListException {
    // TODO Auto-generated method stub
    // TODO: return the username of the removed user
    // TODO: this method should do the tree traversing (upwards) to find the
    // most suitable user (the first one that wanted this project+category, or
    // supercategories),
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
