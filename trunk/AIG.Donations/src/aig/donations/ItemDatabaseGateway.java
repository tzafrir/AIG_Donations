package aig.donations;

import java.util.Date;
import java.util.List;

public interface ItemDatabaseGateway {
  List<Item> retrieveItemsByDonor(String username);
  /**
   * @return The ID of the new Item.
   */
  long addToDB(String name, String description, long projectId, long categoryId,
      ItemStatus status, Date donationTimestamp, String donorUsername, ItemCondition itemCondition);
}
