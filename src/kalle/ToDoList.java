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
	
	
	public void findActivities(String description) {
		List<Activities> temp = findWithString(description);
		for(Activities activitie: temp) {
			Print.print(activitie);
			
		}
		
	}

	public void findActivities(LocalDate date) {
		List<Activities> temp = findWithDate(date);
		for(Activities activitie: temp) {
			Print.print(activitie);
			
		}

	}
	
	public void ListAllActivities() {
		for(Activities activitie:list) {
			Print.print(activitie);
		}
	}
	
	public void getExpiredActivities() {
		
		for(Activities activitie: list) {
			if(activitie.isExpired()) {
				Print.print(activitie);
			}
		}
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

	
	

}
