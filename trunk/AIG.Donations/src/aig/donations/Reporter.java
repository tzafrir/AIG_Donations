package aig.donations;

import java.util.List;

import aig.donations.exceptions.ProjectNotFoundException;

class Reporter extends User {
  
  Reporter(User user) {
    super(user.getUsername(), user.getRole(), user.getName());
  }
  
  List<Item> reportAllItems(long projectId) throws ProjectNotFoundException {
    return Project.retrieveProject(projectId).getAllItems();
  }
  
  List<ReceivedItem> reportReceivedItems(long projectId) throws ProjectNotFoundException {
    return Project.retrieveProject(projectId).getReceivedItems();
  }
  
  List<Item> reportUnreceivedItems(long projectId) throws ProjectNotFoundException {
    return Project.retrieveProject(projectId).getUnreceivedItems();
  }
}
