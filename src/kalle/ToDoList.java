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
	public void findActivities(String description) {
		
		for(Activities activitie: list) {
			if(activitie.getDescription().equals(description)){ 
				Print.print(activitie);
			}
		}
		
	}

	public void findActivities(LocalDate date) {
		for(Activities activitie: list) {
			if(activitie.getDate().equals(date)){ 
				Print.print(activitie);
			}
		}

	}
	
	
	public void getExpiredActivities() {
		
		for(Activities activitie: list) {
			if(activitie.isExpired()) {
				System.out.println(activitie);
			}
		}
	}

	

}
