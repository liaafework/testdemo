package kalle;

import java.time.LocalDate;
import java.util.Scanner;




public class Main {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
	
		ToDoList item = new ToDoList();
		LocalDate today = LocalDate.now();
		boolean flag = true;
		while(flag){

			meny();
			
			int a = inputNrGetNr();
			switch (a) {
			case 1:
				System.out.println("Case "+a); // Tempory
				item.addActivities(today.plusDays(5), "Aktivitet att göra nr 1");
				item.addActivities(today.plusDays(3), "En annan Aktivitet");
				item.addActivities(today.plusDays(1), "Aktivitet 3");
				break;
			case 2:
				System.out.println("Case "+a); // Tempory
				item.findActivities("Aktivitet 3");
	
			
				break;
			case 3:
				String tmp =inputNrGetString();
				
				System.out.println("Ret: "+tmp); // Tempory
				break;
			default:
				flag=false;
				break;
			}
			System.out.println("");

			
		}

		sc.close();
	}
		
	public static int inputNrGetNr() {
		boolean flag = true;
		int number;
		try {
			number = sc.nextInt();
			while(flag) {

				if(number !=0) {
					//retNr=number;
					flag=false;
				}
			}
			return number;
		} catch (ArithmeticException e) {
			System.out.println("Enter a number");
			return 0;
		}
	}
	public static String inputNrGetString() {
		boolean flag = true;
		String str;
		try {
			str = sc.next();
			while(flag) {

				if(!str.equals(null)) {
					//retNr=number;
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
		System.out.println("Press 1 for add somting to do");
		System.out.println("Press 2 for get somting");
		System.out.println("Press 3 för enter a String Date (test of string scanner) return same date");
	}
}
