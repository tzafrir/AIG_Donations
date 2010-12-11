package aig.donations;

public enum ItemCondition {
  EXCELLENT {
    @Override
    public String toString() {
      return "Excellent";
    }
  },
  GOOD {
    @Override
    public String toString() {
      return "Good";
    }
  },
  MEDIUM {
    @Override
    public String toString() {
      return "Medium";
    }
  },
  BAD {
    @Override
    public String toString() {
      return "Bad";
    }
  },
  AWFUL {
    @Override
    public String toString() {
      return "Awful";
    }
  }
}
