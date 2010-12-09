package aig.donations;

enum ItemStatus {
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
  TRANSFERRED {
    @Override
    public String toString() {
      return "Transferred";
    }
  },
  MATCHED {
    @Override
    public String toString() {
      return "Matched";
    }
  }
}
