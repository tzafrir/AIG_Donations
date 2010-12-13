package aig.donations;

import aig.donations.exceptions.EmptyWaitingListException;
import aig.donations.exceptions.ProjectNotFoundException;
import aig.donations.exceptions.UserNotInWaitingListException;

import java.util.Date;

public interface ProjectDatabaseGateway {
  Project retrieveProject(long projectId) throws ProjectNotFoundException;
  /**
   * @return the id of the new Project.
   */
  long addToDB(String name, String description, String location, Date eventTime,
      String socialWorkerUsername);
  void addToWaitingQueue(long projectId, long categoryId, String username);
  /**
   * Removes the first occurence of username from the queue.
   *
   * @throws UserNotInWaitingListException when username is not in the queue.
   */
  void removeUserFromWaitingQueue(long projectId, long categoryId, String username)
      throws UserNotInWaitingListException;
  /**
   * "Pops" the username that was the first to ask for an item of categoryId or an ancestor of it
   * in the category tree, under this project.
   *
   * @return the username of the removed user.
   */
  String removeFirstFromWaitingQueue(long projectId, long categoryId)
      throws EmptyWaitingListException;
}
