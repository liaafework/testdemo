package kalle;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;




/*
 * @author: Lia Afework, Anna Thompson, Tommy Steger
 * @date: 20171101
 * 
 * Receives inputs from user and printouts the different Menu methods 
 * 
 */

public class Meny {
	private Scanner sc = new Scanner(System.in);
	private ToDoList list = new ToDoList();
	String regex = "^((20|21)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";
	
	public void mainMeny() {
			
		boolean flag = true;
		while(flag){
			
			meny();
			String tmp = inputNrGetString();
			switch (tmp) {
			case "1": 
				//Press 1: to add an item to this week
				addActivities();				
				break;
			case "2":
				//Press 2: to add an item and expire date
				addActivitiesAndDate();	
				break;
			case "3":
				//Press 3: to list all activities
				listAllActivitis();
				break;
			case "4":
				//Press 4: to find an activity
				findActivities();
				break;
			case "5":
				//Press 5: to remove an activity
				removeActivities();
				break;
			case "6":
				//Press 6: to find any expired activities
				getExpiredActivities();
				break;
			case "7":
				//Press 7: to search for activities
				findActivitiesLike();
				break;
			case "8":
				//Press 8: to change an activity
				changeDescription();
				break;
			case "9":
				//Press 9: to change an activity date
				changeDate();
				break;
			case "10":
				//Press 10: to remove expireds activities"
				removeExpiredActivities();
				break;
			case "11":
				//Press 11: to list all activities by name
				listAllActivitiesAlfabethical();
				break;
			case "12":
				//Press 12: to Save list
				saveXML();
				break;
			case "13":
				//Press 13: to Load list
				//loadXML();
				System.out.println("Save xml dosen't work");
				break;
			case "x":
			case "X":
				//Press x: to Exite
				System.out.println("Exit program...");
				flag=false;
				break;
			default:
				System.out.println("Not a valid input...");
				break;
			}
			System.out.println("");			
		}
		sc.close();
	}

	private  String inputNrGetString() {
		boolean flag = true;
		String str;
		try {
			str = sc.nextLine();
			while(flag) {

				if(!str.equals(null)) {
					//retNr=number;
					flag=false;
				}
			}
			return str;
		} catch (ArithmeticException e) {
			e.printStackTrace();
			return null;
		}

	}
	private void meny() {
		System.out.println("__________________________________________");
		System.out.println("My ToDo list: (press x to exit)");
		System.out.println("  ");
		System.out.println("Press 1: to add an item to this week");
		System.out.println("Press 2: to add an item and expire date");
		System.out.println("Press 3: to list all activities");
		System.out.println("Press 4: to find an activity");
		System.out.println("Press 5: to remove an activity");
		System.out.println("Press 6: to find any expired activities");
		System.out.println("Press 7: to search for activities");
		System.out.println("Press 8: to change an activity");
		System.out.println("Press 9: to change an activity date");
		System.out.println("Press 10: to remove expireds activities");
		System.out.println("Press 11: to list all activities by name");
		System.out.println("Press 12: to Save list");
		System.out.println("Press 13: to Load list");
	}
	private void addActivities(){
		System.out.println("Enter this weeks activity:");
		String tmp =inputNrGetString();
		LocalDate tmpDate = LocalDate.now();
		int days=tmpDate.getDayOfWeek().getValue();
		list.addActivities(tmpDate.plusDays(7-days) , tmp);
			
		
	}
	private void addActivitiesAndDate(){
		System.out.println("Enter an activity:");
		String tmp =inputNrGetString();		
		System.out.println("Enter an expire date:");
		String tmp2 =inputNrGetString();
		if (chkDateFormatAndExpire(tmp2))
			list.addActivities(LocalDate.parse(tmp2), tmp);
				
	}
	private void listAllActivitis(){
				list.ListAllActivities();		
	}
	private  void findActivities(){
		System.out.println("Enter an activity to find:");
		String tmp =inputNrGetString();
		list.findActivities(tmp);
		
	}
	private void removeActivities(){
		System.out.println("Enter an activity to remove:");
		String tmp =inputNrGetString();
		list.removeActivities(tmp);
	}
	private  void getExpiredActivities(){	
		list.getExpiredActivities();
	}
	private  void findActivitiesLike(){
		
		System.out.println("Enter an activity to search:");
		String tmp =inputNrGetString();
		list.findActivitiesLike(tmp);
		
	}
	private void changeDescription(){
		System.out.println("Enter an activity to change the name:");
		String tmp =inputNrGetString();
		System.out.println("Enter a new name");
		String tmp2 =inputNrGetString();
		list.changeDescription(tmp,tmp2);
	}
	private  void changeDate(){
		System.out.println("Enter an activity to change the date:");
		String tmp =inputNrGetString();
		System.out.println("Enter a new date");
		String tmp2 =inputNrGetString();
		if (chkDateFormatAndExpire(tmp2))
			list.changeDate(tmp,LocalDate.parse(tmp2));
			
	}
	private  void removeExpiredActivities(){	
		list.removeExpiredActivities();
	}
	private void listAllActivitiesAlfabethical(){
		list.ListAllActivitiesAlfabethical();		
	}
	private boolean chkDateFormatAndExpire(String chkDate){
		if (chkDate.matches(regex) && (LocalDate.parse(chkDate).isAfter(LocalDate.now()) || LocalDate.parse(chkDate).equals(LocalDate.now())) )
			return true;
		else {
			System.out.println("The date was not changed\nplease use the correct date format(YYYY-MM-DD)\nThe date must be a date from today or after.");
			return false;
		}
			
		
		 
	}
	private void saveXML(){
		try {

        	XmlIO.saveObject("todolist.xml", list);

        } catch (IOException ex) {
            Logger.getLogger(Meny.class.getName()).log(Level.SEVERE, null, ex);
        }		
	}
	private void loadXML(){
		try {
			list = XmlIO.loadObject("todolist.xml",ToDoList.class);
        } catch (IOException ex) {
            System.out.println("Could not load todolist.xml");
        }
        
	}

}
