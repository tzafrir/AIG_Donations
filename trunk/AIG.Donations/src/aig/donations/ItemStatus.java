package aig.donations;

public enum ItemStatus {
  DONATED {
    @Override
    public String toString() {
      return "Donated";
    }
  },
  PENDING {
    @Override
    public String toString() {
      return "Pending";
    }
  },
  RECEIVED {
    @Override
    public String toString() {
      return "Received";
    }
  },
  RETURNED {
    @Override
    public String toString() {
      return "Returned";
    }
  },
  MATCHED {
    @Override
    public String toString() {
      return "Matched";
    }
  }
}
