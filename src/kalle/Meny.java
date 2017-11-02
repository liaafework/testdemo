package kalle;

import java.time.LocalDate;
import java.util.Scanner;

public class Meny {
	private Scanner sc = new Scanner(System.in);
	private ToDoList item = new ToDoList();
	String regex = "^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";
	
	public void mainMeny() {
			
		boolean flag = true;
		while(flag){
			
			meny();
			String tmp = inputNrGetString();
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
				meny5();
				break;
			case "6":
				meny6();
				break;
			case "7":
				meny7();
				break;
			case "8":
				meny8();
				break;
			case "9":
				meny9();
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
	}
	private void meny1(){
		System.out.println("Enter this weeks activity:");
		String tmp =inputNrGetString();
		LocalDate tmpDate = LocalDate.now();
		int days=tmpDate.getDayOfWeek().getValue();
		item.addActivities(tmpDate.plusDays(7-days) , tmp);
			
		
	}
	private void meny2(){
		System.out.println("Enter an activity:");
		String tmp =inputNrGetString();
		System.out.println("Enter an expire date:");
		String tmp2 =inputNrGetString();
		if (tmp2.matches(regex))
		{
			item.addActivities(LocalDate.parse(tmp2), tmp);
			
		}
		else
		    System.out.println("The date was not changed please use the correct date format(YYYY-MM-DD):");
		
	}
	private void meny3(){
				item.ListAllActivities();		
	}
	private  void meny4(){
		System.out.println("Enter an activity to find:");
		String tmp =inputNrGetString();
		item.findActivities(tmp);
		
	}
	private void meny5(){
		System.out.println("Enter an activity to remove:");
		String tmp =inputNrGetString();
		item.removeActivities(tmp);
	}
	private  void meny6(){	
		item.getExpiredActivities();
	}
	private  void meny7(){
		
		System.out.println("Enter an activity to search:");
		String tmp =inputNrGetString();
		item.findActivitiesLike(tmp);
		
	}
	private void meny8(){
		System.out.println("Enter an activity to change the name:");
		String tmp =inputNrGetString();
		System.out.println("Enter a new name");
		String tmp2 =inputNrGetString();
		item.changeDescription(tmp,tmp2);
	}
	private  void meny9(){
		System.out.println("Enter an activity to change the date:");
		String tmp =inputNrGetString();
		System.out.println("Enter a new date");
		String tmp2 =inputNrGetString();
		if (tmp2.matches(regex))
			item.changeDate(tmp,LocalDate.parse(tmp2));
		else
		    System.out.println("The date was not changed please use the correct date format(YYYY-MM-DD):");
		
	}
	
}
