package aig.donations;

class Receiver extends User {

	Receiver(User user) {
	  super(user.getUsername(), user.getRole(), user.getName());
  }

}
