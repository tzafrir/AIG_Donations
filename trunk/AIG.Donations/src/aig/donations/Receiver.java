package aig.donations;

import java.util.List;

import aig.donations.exceptions.ProjectClosedException;
import aig.donations.exceptions.ProjectNotFoundException;

class Receiver extends User {

	Receiver(User user) {
	  super(user.getUsername(), user.getRole(), user.getName());
  }

	void requestItem(long projectId, long categoryId) throws ProjectClosedException, ProjectNotFoundException {
		if(Project.retrieveProject(projectId).isClosed()) {
			throw new ProjectClosedException("Can't request from a closed project");
		}
		//TODO- check if categoryId exists in project? or it will throw in the DB functions?
		
		//TODO- where is the matching done? if it's here:
		// get an item (the first?) from the project and the category
		// THAT IS ALREADY IN STORAGE (according to the item.status)
		// and change Items in the DB (add a funciton to Item?)
		// if there's no item:
		Project.addToWaitingQueue(projectId, categoryId, getUsername());
	}
	
	List<ReceivedItem> getReceivedItems() {
		return ReceivedItem.retrieveItemsByReceiver(getUsername());
	}
	
	void regretDonation(long projectId, long categoryId) throws ProjectNotFoundException, ProjectClosedException {
		if(Project.retrieveProject(projectId).isClosed()) {
			throw new ProjectClosedException("Can't regret from a closed project");
		}
		//TODO- check if categoryId exists in project? or it will throw in the DB functions?
		
		//TODO- here it get's tricky:
		/*
		 * If we are in the waiting queue, just remove from there.
		 * If we were already matched- either we cannot regret, or we
		 * should find the item and remove its receiver.
		 * Problems- maybe the item was received? maybe its on its way?
		 * We should think when to allow this.
		 * 
		 * NOTE- can a person ask to receive several items in the same category?
		 * If so, we won't know which to regret. If not, we should check it in requestItem.
		 * We should maybe distinguish between several requests in a single project,
		 * a single categories in a project, considering history or not (maybe
		 * we already received before...), single category in several projects. 
		 */
	}
	
}
