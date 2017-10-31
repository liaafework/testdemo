package kalle;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
			
		boolean flag = true;
		while(flag){

			meny();
			String tmp =inputNrGetString();
			switch (tmp) {
			case "1":
			    // Case string "1" 
				addMyActivityToList();
				break;
			case "2":
				ToDoList item = new ToDoList();
				// Case string "2" 
				item.findActivities("Aktivitet 3");
				//System.out.println("Skriv Ut");
			
				break;
			case "3":
				// Case string "3" 
				break;
			case "x":
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
	public static void addMyActivityToList() {
		
		try {
			ToDoList item = new ToDoList();
		//	LocalDate expireDate = null;
			
			String myActivity;
			System.out.println("Input activity ,expire date(ex: WorkTime,2017-11-05)");
			String tmp =inputNrGetString()+",";
			String[] output = tmp.split(",");
			myActivity = output[0].trim();
		//	expireDate = tmp/////////////////////////////////////////LocalDate.parse(output[1].trim()); //TODO bugg fix 
			item.addActivities(LocalDate.now(), myActivity);
		} catch (DateTimeParseException e) {
			
			System.out.println("Date was not correct..\n");
		}
			
	}
	public static String inputNrGetString() {
		boolean flag = true;
		String str;
		try {
			str = sc.next();
			while(flag) {
				if(!str.equals(null)) {
					flag=false;
				}
			}
			return str;
		} catch (ArithmeticException e) {
			System.out.println("Enter a String");
			return null;
		}
	}
	public static void meny() {
		System.out.println("My ToDo List (x for exite)");
		System.out.println("Press 1 for add somting to do");
		System.out.println("Press 2 for get somting");
		System.out.println("Press 3 för somthing");
	}
}
