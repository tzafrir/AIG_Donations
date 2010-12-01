package aig.donations;

import java.util.Date;

import aig.donations.exceptions.CategoryNotFoundException;
import aig.donations.exceptions.ItemNotFoundException;
import aig.donations.exceptions.ProjectAlreadyClosedException;
import aig.donations.exceptions.ProjectNotFoundException;

class SocialWorker extends User {

	SocialWorker(User user) {
	  super(user.getUsername(), user.getRole(), user.getName());
  }

	long createProject(String name, String description, String location, Date eventTime) {
		//TODO: stub
		//TODO: allow calling this if eventTime is in the past (document it to show that this is intentional)
		//TODO: make sure project doesn't exist yet
		//TODO: Project.addToDB(name, description, location, eventTime);
		return 0;
	}
	
	void closeProject(long projectId) throws ProjectNotFoundException, ProjectAlreadyClosedException {
		Project project = Project.retrieveProject(projectId);
		
		if(project.isClosed()) {
			throw new ProjectAlreadyClosedException();
		}
		
		project.setEventTime(new Date());
	}
	
	void renameProject(long projectId, String newName) throws ProjectNotFoundException {
		//TODO: check newName is a legal name
		
		Project.retrieveProject(projectId).setName(newName);
	}
	
	void changeProjectDescription(long projectId, String newDescription) throws ProjectNotFoundException {
		//TODO: check newDescription is a legal description (length and allowed chars)
		
		Project.retrieveProject(projectId).setDescription(newDescription);
	}
	
	void changeProjectLocation(long projectId, String newLocation) throws ProjectNotFoundException {
		//TODO: check newLocation is a legal location (length and allowed chars)
		
		Project.retrieveProject(projectId).setLocation(newLocation);
	}
	
	void changeProjectTime(long projectId, Date newEventTime) throws ProjectNotFoundException {
		//TODO: check newEventTime is a legal date (if there is such a thing as an illegal date... maybe call a method that returns true, for future options)
		
		Project.retrieveProject(projectId).setEventTime(newEventTime);
	}
	
	void addCategoryToProject(long projectId, long categoryId) throws ProjectNotFoundException, CategoryNotFoundException {
		//make sure category exists:
		Category.retrieveCategory(categoryId);
		
		Project.retrieveProject(projectId).addCategory(categoryId);
	}
	
	void moveItem(long sourceProjectId, long destinationProjectId, long itemId) throws ItemNotFoundException {
    Item item = Item.retrieveItem(itemId);
    
    if(sourceProjectId != item.getProject().getId()) {
    	//item isn't in sourceProjectId
    	//TODO: throw something?
      //TODO: consider not receiving sourceProjectId as a parameter
    }
    
    //TODO: do we need to check if the destination project is closed?
    
    item.setProject(destinationProjectId);
	}
	
	void changeItemStatus(long itemId, ItemStatus newStatus) throws ItemNotFoundException {
    Item item = Item.retrieveItem(itemId);
    
    //TODO: make sure transition is legal (according to state diagram)
    
    item.setStatus(newStatus);
	}
}
