package aig.donations;

import java.util.Date;
import java.util.List;

public interface ReceivedItemDatabaseGateway {
  /**
   * @return items with receiver username and status MATCHED.
   */
  List<ReceivedItem> retrieveMatchedItemsByReceiver(String username);
  /**
   * @return a list of pairs, where each pair of project+category
   * represents that 'username' is waiting in the waiting queue for that
   * category in that project.
   */
  List<Pair<Project, Category>> retrieveWaitingDataByReceiver(String username);
}
