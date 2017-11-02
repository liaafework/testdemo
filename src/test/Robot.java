package test;

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
	
    
    
}
