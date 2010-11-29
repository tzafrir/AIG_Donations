package aig.donations;

import java.util.Date;

class SocialWorker extends User {

	SocialWorker(User user) {
	  super(user.getUsername(), user.getRole(), user.getName());
  }

	long createProject(String name, String description, String location, Date eventTime) {
		//TODO: stub
		//TODO: allow calling this if eventTime is in the past (document it to show that this is intentional.
		//TODO: make sure project doesn't exist yet
		//TODO: Project.addToDB(name, description, location, eventTime);
		return 0;
	}
	
	void closeProject(long projectId) {
		//TODO: stub
		//TODO: close the project whose id is 'projectId' (make sure it exists and is open) by changing its time to the present.
		//TODO: Project.setEventTime(new Date());
	}
	
	void renameProject(long projectId, String newName) {
		//TODO: stub
		//TODO: Project.setName(newName);
	}
	
	void changeProjectDescription(long projectId, String newDescription) {
	  //TODO: stub
		//TODO: Project.setDescription(newDescription);
	}
	
	void changeProjectLocation(long projectId, String newLocation) {
		//TODO: stub
		//TODO: Project.setLocation(newLocation);
	}
	
	void changeProjectTime(long projectId, Date newEventTime) {
	  //TODO: stub
		//TODO: Project.setEventTime(newEventTime);
	}
	
	void addCategoryToProject(long projectId, long categoryId) {
		//TODO: stub
		//TODO: Project.addCategory(categoryId);
	}
	
	void moveItem(long sourceProjectId, long destinationProjectId, long itemId) {
		//TODO: stub
		//TODO: make sure item is in sourceProjectId (consider not receiving this as a parameter)
		//TODO: Item.setProject(destinationProjectId);
	}
	
	void changeItemStatus(long itemId, ItemStatus newStatus) {
		//TODO: stub
		//TODO: make sure item exists. Make sure transition is legal (according to state diagram)
		//TODO: Item.setStatus(newStatus);
	}
}
