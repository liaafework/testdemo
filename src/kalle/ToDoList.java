package kalle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ToDoList {
	
	private List<Activities>list = new ArrayList<>();
	
	
	public void addActivities(LocalDate expieringDate, String description) {
		list.add(new Activities(expieringDate, description));
	}
	
	
	
	public void removeActivities(String description) {
		
		int removed = 0;
		List<Activities>toRemove = findWithString(description);
		
		for(Activities activitie:toRemove) {
			remove(activitie);
			removed ++;
		}
		
		if(removed == 0) {
			Print.print("No activities were removed");
		}
		else {
			Print.print(removed + " activities were removed");
		}
	
	}
	
	public void removeExpiredActivities() {
		int removed = 0;
		List<Activities> temp = findExpired();
		if(!temp.isEmpty()) {
			for(Activities activitie: temp) {
				remove(activitie);
				removed++;
			}
			
			Print.print(removed + "activities were removed");
		}
		else {
		
			Print.print("No activities with expired dates");
		}
		
	}
	
	
	public void findActivities(String description) {
		List<Activities> temp = findWithString(description);
		if(!temp.isEmpty()) {
			for(Activities activitie: temp) {
			Print.print(activitie);
			}
		}
		else {	
			Print.print("No activities found");
		}
		
	}

	public void findActivities(LocalDate date) {
		List<Activities> temp = findWithDate(date);
		if(!temp.isEmpty()) {
			for(Activities activitie: temp) {
				Print.print(activitie);
			}
		}
		else {
			Print.print("No activities found");
		}

	}
	
	public void ListAllActivities() {
		if(!list.isEmpty()) {
			for(Activities activitie:list) {
				Print.print(activitie);
			}
		}
		else {
			Print.print("No activies in the list");
		}
		
	}
	
	public void getExpiredActivities() {
		List<Activities> temp = findExpired();
		if(!temp.isEmpty()) {
			Print.print("Expired activities");
			for(Activities activitie: temp) {
				Print.print(activitie);
			}
		}
		else {
		
			Print.print("No activities with expired dates");
		}
		
	}
	
	public void changeDescriotion(String oldDescription, String newDescription) {
		List<Activities> temp = findWithString(oldDescription);
		int changed = 0;
		if(temp.isEmpty()) {
			Print.print("No activities found");
		}
		for(Activities activitie: list) {
			activitie.setDescription(newDescription);
			changed++;
		}
		Print.print(changed + " activitie descriptions have changed");
		
	}
	
	public void changeDate(String description, LocalDate newDate) {
		List<Activities> temp = findWithString(description);
		int changed = 0;
		if(temp.isEmpty()) {
			Print.print("No activities found");
		}
		for(Activities activitie: list) {
			activitie.setDate(newDate);
			changed++;
		}
		Print.print(changed + " activitie dates have changed");
		
	}
	
	private List<Activities> findWithString(String description) { 
		List<Activities>temp = new ArrayList<>();
		for(Activities activitie: list) {
			if(activitie.getDescription().equals(description)){ 
				temp.add(activitie);
			}
		}
		return temp;
	}
	
	private List<Activities> findWithDate(LocalDate date) { 
		List<Activities>temp = new ArrayList<>();
		for(Activities activitie: list) {
			if(activitie.getDate().equals(date)){ 
				temp.add(activitie);
			}
		}
		return temp;
	}

	private void remove(Activities ActivitieToRemove) {
		Iterator<Activities> iter = list.iterator();

		while(iter.hasNext()) {
			if(iter.next().equals(ActivitieToRemove)) {
				iter.remove();
			}
		}
	}
	
	private List<Activities> findExpired(){
		List<Activities>temp = new ArrayList<>();
		for(Activities activitie: list) {
			if(activitie.isExpired()) {
				temp.add(activitie);
				
			}
		}
		return temp;
	}


}
