package kalle;

import java.io.Serializable;
import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import test.LocalDateAdapter;


public class Activities implements Serializable, Comparable<Activities>{
	
	private static final long serialVersionUID = 1L;
	
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	private LocalDate date;
	
	 private String description;
	
	
	public Activities(LocalDate date, String description) {
		super();
		this.description = description;
		this.date = date;
	}
	
	public Activities(String description) {
		this(LocalDate.now(), description);		
	}


	public LocalDate getLocalDate() {
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
		
		return this.date.compareTo (o.getLocalDate());
	}
		 
	 
	public String toString() {
		return "Activity: Date: " + date + ", Description: " + description;
	}
}
