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
	
	
	
	public void removeActibities(Activities ActivitieToRemove) {
		
		Iterator<Activities> iter = list.iterator();
		
		while(iter.hasNext()) {
			if(iter.next().equals(ActivitieToRemove)) {
				iter.remove();
			}
		}
	}
	
	// Method finds a Activities by matching desctiption, returns null if not found
	public Activities findActivities(String description) {
		
		for(Activities activitie: list) {
			if(activitie.getDescription().equals(description)){ //TODO change to get method in Activities
				return activitie;
			}
		}
		
		return null;
	}
	

	
}
