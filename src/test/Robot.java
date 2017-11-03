package test;

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
	
    
    
}
