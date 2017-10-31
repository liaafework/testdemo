package kalle;

import java.util.Scanner;
import java.util.function.ToIntFunction;



public class Main {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
	
		boolean flag = true;
		while(flag){

			meny();
			
			int a = inputNrGetNr();
			switch (a) {
			case 1:
				System.out.println("Case "+a); // Tempory
				break;
			case 2:
				System.out.println("Case "+a); // Tempory
				break;
			case 3:
				System.out.println("Case "+a); // Tempory
				break;
			default:
				flag=false;
				break;
			}
			System.out.println("Exit2 "+a);

			
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
		System.out.println("Press 1 for Item1\nPress 2 for  Item2\nPress 3 for  Item3");
	}
}
