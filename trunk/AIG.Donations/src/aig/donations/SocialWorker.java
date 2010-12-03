package aig.donations;

import java.util.Date;

import aig.donations.exceptions.CategoryNotFoundException;
import aig.donations.exceptions.IllegalItemStatusTransition;
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
		//TODO: do we need to make sure project doesn't exist yet? i think this quad can be replicated... (meaning, 2 projects with the same name, etc.)
		return Project.addToDB(name, description, location, eventTime);
	}
	
	void closeProject(long projectId) throws ProjectNotFoundException, ProjectAlreadyClosedException {
		Project project = Project.retrieveProject(projectId);
		
		if(project.isClosed()) {
			throw new ProjectAlreadyClosedException("can't close a project that is already closed");
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
    
    /*if(sourceProjectId != item.getProject().getId()) {
    	//item isn't in sourceProjectId
    	//TODO: throw new ItemSourceProjectMismatchException?
      //TODO: consider not receiving sourceProjectId as a parameter
    }*/
    
    //TODO: do we need to check if the destination project is closed? I don't think so... since this operation can be done retroactively by the social worker, to describe the past... --> document our decision
    
    item.setProject(destinationProjectId);
	}
	
	void changeItemStatus(long itemId, ItemStatus newStatus) throws ItemNotFoundException, IllegalItemStatusTransition {
    Item item = Item.retrieveItem(itemId);
    
    final ItemStatus oldStatus = item.getStatus();
    if (!isTransitionLegal(oldStatus, newStatus)) {
    	throw new IllegalItemStatusTransition(oldStatus.toString(), newStatus.toString());
    }
    
    item.setStatus(newStatus);
	}

	private boolean isTransitionLegal(ItemStatus oldStatus, ItemStatus newStatus) {
	  //TODO: refactor: move this method to somewhere more appropriate, like Item, or ItemStatus
	  switch (oldStatus) {
	  case DONATED:
	  	return (newStatus == ItemStatus.PENDING);
	  case PENDING:
	  	return (newStatus == ItemStatus.MATCHED ||
	  			    newStatus == ItemStatus.TRANSFERRED);
	  case MATCHED:
	  	return (newStatus == ItemStatus.RECEIVED ||
	  			    newStatus == ItemStatus.PENDING);
	  case TRANSFERRED:
	  	return (newStatus == ItemStatus.PENDING);
	  }
		return false;
  }
}
