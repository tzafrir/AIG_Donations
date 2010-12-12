package aig.donations;

import java.util.List;

import aig.donations.exceptions.IllegalUserNameException;
import aig.donations.exceptions.IllegalUserNameLengthException;
import aig.donations.exceptions.IllegalUserRoleException;
import aig.donations.exceptions.IllegalUserUsernameException;
import aig.donations.exceptions.IllegalUserUsernameLengthException;
import aig.donations.exceptions.IncorrectSocialWorkerException;
import aig.donations.exceptions.ProjectNotFoundException;

public class Reporter extends User {
  
  Reporter(User user) throws IllegalUserNameLengthException, IllegalUserUsernameLengthException,
      IllegalUserNameException, IllegalUserRoleException, IllegalUserUsernameException {
    super(user.getUsername(), user.getRole(), user.getName());
  }
  
  public List<Item> reportAllItems(long projectId) throws ProjectNotFoundException,
      IncorrectSocialWorkerException {
    return getOurProject(projectId).getAllItems();
  }
  
  public List<ReceivedItem> reportReceivedItems(long projectId) throws ProjectNotFoundException,
      IncorrectSocialWorkerException {
    return getOurProject(projectId).getReceivedItems();
  }
  
  public List<Item> reportUnreceivedItems(long projectId) throws ProjectNotFoundException,
      IncorrectSocialWorkerException {
    return getOurProject(projectId).getUnreceivedItems();
  }
  
  private Project getOurProject(long projectId) throws ProjectNotFoundException,
      IncorrectSocialWorkerException {
    Project project = Project.retrieveProject(projectId);
    checker.checkThatProjectIsOurs(project, getUsername(), getRole());
    return project;
  }
  
//TODO- use Project in a way we can use stubs (ProjectGateway?)
}
