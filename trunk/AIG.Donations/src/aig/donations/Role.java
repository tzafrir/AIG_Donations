package aig.donations;

enum Role {
  SYSTEM_ADMIN {
  	@Override
    public String toString() {
  	  return "System admin";
    }
  },
  DONOR {
  	@Override
    public String toString() {
  	  return "Donor";
    }
  },
  RECEIVER {
  	@Override
    public String toString() {
  	  return "Receiver";
    }
  },
  SOCIAL_WORKER {
  	@Override
    public String toString() {
  	  return "Social worker";
    }
  }
}
