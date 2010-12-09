package aig.donations;

import java.util.List;

import aig.donations.exceptions.IncorrectSocialWorkerException;
import aig.donations.exceptions.ProjectNotFoundException;

class Reporter extends User {
  
  Reporter(User user) {
    super(user.getUsername(), user.getRole(), user.getName());
  }
  
  List<Item> reportAllItems(long projectId) throws ProjectNotFoundException,
      IncorrectSocialWorkerException {
    return getOurProject(projectId).getAllItems();
  }
  
  List<ReceivedItem> reportReceivedItems(long projectId) throws ProjectNotFoundException,
      IncorrectSocialWorkerException {
    return getOurProject(projectId).getReceivedItems();
  }
  
  List<Item> reportUnreceivedItems(long projectId) throws ProjectNotFoundException,
      IncorrectSocialWorkerException {
    return getOurProject(projectId).getUnreceivedItems();
  }
  
  private Project getOurProject(long projectId) throws ProjectNotFoundException,
      IncorrectSocialWorkerException {
    Project project = Project.retrieveProject(projectId);
    checker.checkThatProjectIsOurs(project, getUsername(), getRole());
    return project;
  }
  
}
