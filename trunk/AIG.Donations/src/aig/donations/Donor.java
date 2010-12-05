package aig.donations;

import java.util.Date;
import java.util.List;

import aig.donations.exceptions.CategoryDoesNotExistInProjectException;
import aig.donations.exceptions.ProjectClosedException;
import aig.donations.exceptions.ProjectNotFoundException;

class Donor extends User {

	Donor(User user) {
	  super(user.getUsername(), user.getRole(), user.getName());
  }

	void donateItem(long projectId, long categoryId, String itemName, String itemDescription)
	               throws ProjectNotFoundException, ProjectClosedException,
	                      CategoryDoesNotExistInProjectException {
		
		Project project = Project.retrieveProject(projectId);
		if(project.isClosed()) {
			//also checks that the project exists
			throw new ProjectClosedException("Can't donate to a closed project");
		}
		if(!project.hasCategory(categoryId)) {
			throw new CategoryDoesNotExistInProjectException("No such category in the project");
		}
		ParameterLegalityChecker checker = new ParameterLegalityChecker();
		checker.checkItemName(itemName);
		checker.checkItemDescription(itemDescription);

		new Item().addToDB(itemName, itemDescription, projectId, categoryId,
				         ItemStatus.DONATED, new Date(), getUsername());
	}
	
	List<Item> getDonatedItems() {
		return new Item().retrieveItemsByDonor(getUsername());
	}
}
