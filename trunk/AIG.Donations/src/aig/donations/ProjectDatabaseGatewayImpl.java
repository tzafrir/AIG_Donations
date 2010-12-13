package aig.donations;

import aig.donations.exceptions.EmptyWaitingListException;
import aig.donations.exceptions.ProjectNotFoundException;
import aig.donations.exceptions.UserNotInWaitingListException;

import java.util.Date;

public class ProjectDatabaseGatewayImpl implements ProjectDatabaseGateway {
  public Project retrieveProject(long projectId) throws ProjectNotFoundException {
    // TODO(tzafrir/vania): Implement.
    return null;
  }

  public long addToDB(String name, String description, String location, Date eventTime,
      String socialWorkerUsername) {
    // TODO(tzafrir/vania): Implement.
    return 0;
  }

  public void addToWaitingQueue(long projectId, long categoryId, String username) {
    // TODO(tzafrir/vania): Implement.
  }

  public void removeUserFromWaitingQueue(long projectId, long categoryId, String username)
      throws UserNotInWaitingListException {
    // TODO(tzafrir/vania): Implement.
  }

  public String removeFirstFromWaitingQueue(long projectId, long categoryId)
      throws EmptyWaitingListException {
    // TODO(tzafrir/vania): Implement.
    return null;
  }

}
