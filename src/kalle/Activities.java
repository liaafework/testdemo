package kalle;

import java.io.Serializable;
import java.time.LocalDate;


public class Activities implements Serializable, Comparable<Activities>{
	
	private static final long serialVersionUID = 1L;
	private LocalDate date;
	private String description;
	
	
	public Activities(LocalDate date, String description) {
		super();
		this.date = date;
		this.description = description;
	}


	public LocalDate getDate() {
		return date;
	}


	public String getDescription() {
		return description;
	}

	

	public void setDate(LocalDate date) {
		this.date = date;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isExpired() {
		
		LocalDate today = LocalDate.now();

		if (today.isAfter(date)) {
			return true;
		}

		else {
			return false;
		}
		
	}
	@Override
	public int compareTo(Activities o) {
		
		return this.date.compareTo (o.getDate());
	}
		 
	 
	public String toString() {
		return "Activity: Date: " + date + ", Description: " + description;
	}
}
