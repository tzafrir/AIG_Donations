package aig.donations;

class SocialWorker extends User {

	SocialWorker(User user) {
	  super(user.getUsername(), user.getRole(), user.getName());
  }

}
