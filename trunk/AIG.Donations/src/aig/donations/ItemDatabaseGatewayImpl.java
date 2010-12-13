package aig.donations;

import java.util.Date;
import java.util.List;

import aig.donations.exceptions.ItemNotFoundException;

public class ItemDatabaseGatewayImpl implements ItemDatabaseGateway {
  public Item retrieveItem(long itemId) throws ItemNotFoundException {
    // TODO(tzafrir/vania): Implement.
    return null;
  }
  public List<Item> retrieveItemsByDonor(String username) {
    // TODO(tzafrir/vania): Implement.
    return null;
  }
  public long addToDB(String name, String description, long projectId, long categoryId, ItemStatus status,
      Date donationTimestamp, String donorUsername, ItemCondition itemCondition) {
    // TODO(tzafrir/vania): Implement.
    return 0;
  }
}
