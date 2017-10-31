package kalle;

import java.time.LocalDate;

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
		return expired;
	}

	
	
}
