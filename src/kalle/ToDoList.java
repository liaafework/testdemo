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
		boolean flag = true;
		for(Activities activitie: list) {
			if(activitie.isExpired()) {
				Print.print(activitie);
				flag = false;
			}
		}
		if(flag) {
			Print.print("No activities with expired dates");
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

	private void remove(Activities ActivitieToRemove) {
		Iterator<Activities> iter = list.iterator();

		while(iter.hasNext()) {
			if(iter.next().equals(ActivitieToRemove)) {
				iter.remove();
			}
		};
	}


}
