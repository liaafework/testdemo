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
				item.addActivities(today.plusDays(5), "Nära nu");
				break;
			case 2:
				System.out.println("Case "+a); // Tempory
				System.out.println(item.findActivities("Nära nu"));
				
			
				break;
			case 3:
				System.out.println("Case "+a); // Tempory
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
	public static void meny() {
		System.out.println("Press 1 for add somting to do");
		System.out.println("Press 2 for get somting");
	}
}
