package test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import kalle.XmlIO;

public class TestOfSomeFunctions {

private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Robot robot = new Robot("Test", "Model1", 10);
		
		    TestToDoList todolist = new TestToDoList();
			boolean flag = true;
			while(flag){
				
				System.out.println("Save : 1\nLoad : 2\nAdd : 3\nList : 4\nExit : x");
				String tmp = inputNrGetString();
				switch (tmp) {
				case "1": {
                    // Using XmlIO to save an object to file, errors are unexpected (write protected files)
                    try {
                    	XmlIO.saveObject("todolist_test.xml", todolist);
                        break;
                    } catch (IOException ex) {
                        Logger.getLogger(TestOfXML.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                case "2": {
                    // Loading with XmlIO, in this case the file might be missing.
                    try {
                        todolist = XmlIO.loadObject("todolist_test.xml", TestToDoList.class);
                    } catch (IOException ex) {
                        System.out.println("Could not load todolist.xml");
                    }
                    break;
                }
                case "3" :{
                
            		LocalDate tmpDate = LocalDate.now();
            		int days=tmpDate.getDayOfWeek().getValue();
            		todolist.addActivities(tmpDate.plusDays(7-days) , "Test");
                }
                case "4" :{
                	todolist.ListAllActivities();
                }
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
	
	private static  String inputNrGetString() {
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

}