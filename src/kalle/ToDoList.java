package kalle;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
	
	private List<Activities>list = new ArrayList<>();
	
	public void addActivitie(Activities newActivitie) {
		list.add(newActivitie);
	}

}
