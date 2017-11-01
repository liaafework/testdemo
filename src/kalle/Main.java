package kalle;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	static ToDoList item = new ToDoList();
	public static void main(String[] args) {
			
		boolean flag = true;
		while(flag){

			meny();
			String tmp =inputNrGetString();
			switch (tmp) {
			case "1":
			    // Case string "1"
				tmp =inputNrGetString();
				item.addActivities(LocalDate.now(), tmp);
				System.out.println(tmp);	
				break;
			case "2":
				// Case string "2" 
				tmp =inputNrGetString();
				item.addActivities(LocalDate.now().plusWeeks(1), tmp);	
				break;
			case "3":
				// Case string "3" 
				item.findActivities("Aktivitet 3");	
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
	
	
	public static String inputNrGetString() {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		
	}
	
	
	public static void meny() {
		System.out.println("My ToDo List (x for exite)");
		System.out.println("Press 1 for add Items to this week");
		System.out.println("Press 2 for add items to do next week");
		System.out.println("Press 3 för somthing");
	}
}
