package aig.donations;

class Donor extends User {

	Donor(User user) {
	  super(user.getUsername(), user.getRole(), user.getName());
  }

}
