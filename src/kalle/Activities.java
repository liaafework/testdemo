package kalle;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class Activities {
	
	private LocalDate date;
	private String description;
	private boolean expired;
	
	
	public Activities(LocalDate date, String description) {
		super();
		this.date = date;
		this.description = description;
		this.expired = false;
	}


	public LocalDate getDate() {
		return date;
	}


	public String getDescription() {
		return description;
	}


	public boolean isExpired() {
		
		LocalDate today = LocalDate.now();
		
		System.out.println(today);

		if (today.isAfter(date)) {
			return true;
		}

		else {
			return false;
		}
	}
	
	public String toString() {
		return "Activity: Date = " + date + ", Description = " + description;
	}
}
