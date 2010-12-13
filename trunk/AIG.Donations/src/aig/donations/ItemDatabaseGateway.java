package aig.donations;

import java.util.Date;
import java.util.List;

import aig.donations.exceptions.ItemNotFoundException;

public interface ItemDatabaseGateway {
  Item retrieveItem(long itemId) throws ItemNotFoundException;
  List<Item> retrieveItemsByDonor(String username);
  /**
   * @return The ID of the new Item.
   */
  long addToDB(String name, String description, long projectId, long categoryId,
      ItemStatus status, Date donationTimestamp, String donorUsername, ItemCondition itemCondition);
}
