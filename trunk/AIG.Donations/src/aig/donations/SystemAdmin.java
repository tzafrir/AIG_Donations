package aig.donations;

class SystemAdmin extends User {

	SystemAdmin(User user) {
	  super(user.getUsername(), user.getRole(), user.getName());
  }
}
