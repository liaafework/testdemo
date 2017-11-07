package kalle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * @author: Lia Afework, Anna Thompson, Tommy Steger
 * @date: 20171101
 * 
 * This class arranges the list by adding, removing and editing activities and dates 
 * 
 */

public class ToDoList {
	
	public List<Activities>list;
	
	
	public ToDoList() {
		
		
		try {
			ReadFromFile rff = new ReadFromFile();
			list = rff.read("testFile");
		}
		catch(FileNotFoundException e) {
			list = new ArrayList<>(); 
		}
		catch(IOException e) {
			System.out.println("Could not read from file, error: " + e);
		}
		catch(ClassNotFoundException e) {
			System.out.println("Could not read from file, error: " + e);
		}
		
	}
	
	public List<Activities> getList(){
		return list;
	}
	
	public void setlist(List<Activities> list) {
				
		this.list = list;
		
	}
	
	
	public void addActivities(LocalDate expieringDate, String description) {
		list.add(new Activities(expieringDate, description));
		save();
	}
	
	public void save()  {
		SaveToFile stf = new SaveToFile();
		try {
			stf.saveList("testFile", list);
		}
		catch(IOException e) {
			System.out.println("Could not save file, error: " + e);
		}
	}
	
	public void removeActivities(String description) {
		
		int removed = 0;
		List<Activities>toRemove = findWithString(description);
		
		for(Activities activitie:toRemove) {
			list.remove(activitie);
			removed ++;
		}
		
		if(removed == 0) {
			System.out.println("No activities were removed");
		}
		else {
			System.out.println(removed + " activities were removed");
		}
		save();
	}
	
	public void removeExpiredActivities() {
		int removed = 0;
		List<Activities> temp = findExpired();
		if(!temp.isEmpty()) {
			for(Activities activitie: temp) {
				list.remove(activitie);
				removed++;
			}
			
			System.out.println(removed + " activities were removed");
		}
		else {
		
			System.out.println("No activities with expired dates");
		}
		save();
	}
	
	
	public void findActivities(String description) {
		List<Activities> temp = findWithString(description);
		if(!temp.isEmpty()) {
			System.out.println(temp);
		}
		else {	
			System.out.println("No activities found");
		}
		
	}
	
	public void findActivitiesLike(String description) {
		boolean notFound = true;
		for(Activities activitie: list) {
			if(activitie.getDescription().toLowerCase().contains(description.toLowerCase())){ 
				System.out.println(activitie);
				notFound = false;
			}
		}
		if(notFound) {
			System.out.println("No activities found");
		}
	}

	public void findActivities(LocalDate date) {
		List<Activities> temp = findWithDate(date);
		if(!temp.isEmpty()) {
			System.out.println(temp);
		}
		else {
			System.out.println("No activities found");
		}

	}
	
	public void ListAllActivities() {
		if(!list.isEmpty()) {
			Print.printSorted(list);
		}
		else {
			System.out.println("No activies in the list");
		}
	}
	
	public void ListAllActivitiesAlfabethical() {
		if(!list.isEmpty()) {
			Print.printAlfabethical(list);
		}
		else {
			System.out.println("No activies in the list");
		}
	}
	
	public void getExpiredActivities() {
		List<Activities> temp = findExpired();
		if(!temp.isEmpty()) {
			System.out.println("Expired activities");
			Print.printSorted(temp);
		}
		else {
		
			System.out.println("No activities with expired dates");
		}
		
	}
	
	public void changeDescription(String oldDescription, String newDescription) {
		List<Activities> temp = findWithString(oldDescription);
		int changed = 0;
		if(temp.isEmpty()) {
			System.out.println("No activities found");
		}
		for(Activities activitie: temp) {
			activitie.setDescription(newDescription);
			changed++;
		}
		System.out.println(changed + " activitie descriptions have changed");
		save();
	}
	
	public void changeDate(String description, LocalDate newDate) {
		List<Activities> temp = findWithString(description);
		int changed = 0;
		if(temp.isEmpty()) {
			System.out.println("No activities found");
		}
		for(Activities activitie: temp) {
			activitie.setDate(newDate);
			changed++;
		}
		System.out.println(changed + " activitie dates have changed");
		save();
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
			if(activitie.getLocalDate().equals(date)){ 
				temp.add(activitie);
			}
		}
		return temp;
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
