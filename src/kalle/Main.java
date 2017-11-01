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
				meny1();				
				break;
			case "2":
				meny2();	
				break;
			case "3":
				meny3();
				break;
			case "4":
				meny4();
				break;
			case "5":
				//meny5();
				break;
			case "6":
				meny6();
				break;
			case "7":
				meny7();
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
		System.out.println("Press 3 list all activitys");
		System.out.println("Press 4 find activity");
		System.out.println("Press 5 remove activity");
		System.out.println("Press 6 find expired activitys ");
		System.out.println("Press 7 add TEMPORY LIST ");
	}
	public static void meny1(){
		System.out.println("Enter this weeks activity");
		String tmp =inputNrGetString();
		item.addActivities(LocalDate.now(), tmp);
		System.out.println("(Tempory info)"+tmp+ " Is added to activity");	
	}
	public static void meny2(){
		System.out.println("Enter next weeks activity");
		String tmp =inputNrGetString();
		item.addActivities(LocalDate.now().plusWeeks(1), tmp);
		System.out.println("(Tempory info)"+tmp+ " Is added to activity");	
	}
	public static void meny3(){
				item.ListAllActivities();		
	}
	public static void meny4(){
		System.out.println("Enter activity to found");
		String tmp =inputNrGetString();
		item.findActivities(tmp);
		System.out.println("(Tempory info)Seek for:"+tmp);	
	}
	public static void meny5(){
		System.out.println("Enter activity to remove");
		String tmp =inputNrGetString();
		item.removeActivities(tmp);
		System.out.println("(Tempory info)Seek for Remove:"+tmp);	
	}
	public static void meny6(){	
		item.getExpiredActivities();
	}
	public static void meny7(){
		
		item.addActivities(LocalDate.now().plusWeeks(1), "JAVA for dummys");
		item.addActivities(LocalDate.now().minusDays(50), "Java nu");
		item.addActivities(LocalDate.now().minusMonths(5), "Kämpa med lista");
		item.addActivities(LocalDate.now().minusYears(5), "Jobba på lista");
		item.addActivities(LocalDate.now().plusYears(2), "datum på lista");
		System.out.println("(Tempory info) TEMP LIST Is added to activity");	
	}
}
