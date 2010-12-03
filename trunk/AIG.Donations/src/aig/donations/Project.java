package aig.donations;

import java.util.Date;

import aig.donations.exceptions.ProjectNotFoundException;

class Project {
//TODO: stub
	static Project retrieveProject(long projectId) throws ProjectNotFoundException {
	  // TODO Auto-generated method stub
	  return null;
  }

	void setName(String newName) {
	  // TODO Auto-generated method stub
	  
  }

	void setDescription(String newDescription) {
	  // TODO Auto-generated method stub
	  
  }

	void setLocation(String newLocation) {
	  // TODO Auto-generated method stub
	  
  }

	void setEventTime(Date newEventTime) {
	  // TODO Auto-generated method stub
	  
  }

	void addCategory(long categoryId) {
	  // TODO Auto-generated method stub
	  
  }

	long getId() {
	  // TODO Auto-generated method stub
	  return 0;
  }

	boolean isClosed() {
	  // TODO Auto-generated method stub
	  return false;
  }

	static long addToDB(String name, String description, String location, Date eventTime) {
	  // TODO Auto-generated method stub
		//TODO: should return the id generated for this project
	  return 0;
  }

	public static void addToWaitingQueue(long projectId, long categoryId, String username) {
	  // TODO Auto-generated method stub
	  
  }

}
