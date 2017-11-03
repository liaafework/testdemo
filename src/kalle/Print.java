package kalle;

import java.util.Collections;
import java.util.List;

/*
 * @author: Lia Afework, Anna Thompson, Tommy Steger
 * @date: 20171101
 * 
 * Different printout methods. The last method sorts and prints in alphabetical order 
 * 
 */
public class Print {
	
	public static void print(Activities activitie) {
		System.out.println(activitie);
	}
	
	public static void print(String s) {
		System.out.println(s);
	}
	
	public static void print(List<Activities>list) {
		Collections.sort(list);
		for(Activities activitie: list) {
			System.out.println(activitie);
		}
	}
	
	public static void printAlfabethical(List<Activities>list) {
		Collections.sort(list, (a1, a2) -> (a1.getDescription().compareTo(a2.getDescription())));
		for(Activities activitie: list) {
			System.out.println(activitie);
		}
	}

}
