package test;

import java.time.LocalDate;
import java.util.List;

public class Robot {
	
	private String name ;
    private String model ;
    private int power ;
    public List<String> Components;
	public Robot(String name, String model, int power) {
		super();
		name = name;
		model = model;
		power = power;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		model = model;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		power = power;
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
