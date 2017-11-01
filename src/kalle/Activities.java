package kalle;

import java.time.LocalDate;


public class Activities {
	
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
	
	public int compareTo(Activities o) {
		
		return this.date.compareTo (o.getDate());
	}
		 
	 
	public String toString() {
		return "Activity: Date: " + date + ", Description: " + description;
	}
}
