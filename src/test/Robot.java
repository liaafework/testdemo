package test;

import java.time.LocalDate;
import java.util.List;

public class Robot {
	
	public String Name ;
    public String Model ;
    public int Power ;
    public List<String> Components;
	public Robot(String name, String model, int power) {
		super();
		Name = name;
		Model = model;
		Power = power;
		
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public int getPower() {
		return Power;
	}
	public void setPower(int power) {
		Power = power;
	}
	public List<String> getComponents() {
		return Components;
	}
	
//	private boolean chkDateFormatAndExpire(String chkDate){
//		if (chkDate.matches(regex) && (LocalDate.parse(chkDate).isAfter(LocalDate.now()) || LocalDate.parse(chkDate).equals(LocalDate.now())) )
//			return true;
//		else {
//			System.out.println("The date was not changed\nplease use the correct date format(YYYY-MM-DD)\nThe date must be a date from today or after.");
//			return false;
//		}
//	if (chkDateFormatAndExpire(tmp2))
//		item.addActivities(LocalDate.parse(tmp2), tmp);
    
}
