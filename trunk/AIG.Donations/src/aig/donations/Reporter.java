package aig.donations;

class Reporter extends User {

	Reporter(User user) {
	  super(user.getUsername(), user.getRole(), user.getName());
  }
}
