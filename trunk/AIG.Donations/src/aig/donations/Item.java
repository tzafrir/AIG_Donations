package aig.donations;

import java.util.Date;
import java.util.List;

import aig.donations.exceptions.ItemNotFoundException;

class Item {
  // TODO: stub
  static Item retrieveItem(long itemId) throws ItemNotFoundException {
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
  
  static long addToDB(String name, String description, long projectId, long categoryId,
      ItemStatus status, Date donationTimestamp, String donorUsername, ItemCondition itemCondition) {
    return 0;
    // TODO Auto-generated method stub
    // TODO: return new item id
    
  }
  
  Category getCategory() {
    // TODO Auto-generated method stub
    return null;
  }
  
  void setCategory(long newCategoryId) {
    // TODO Auto-generated method stub
    
  }
  
}
