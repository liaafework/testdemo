package kalle;

import java.io.Serializable;
import java.time.LocalDate;

<<<<<<< HEAD
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import test.LocalDateAdapter;

=======
/*
 * @author: Lia Afework, Anna Thompson, Tommy Steger
 * @date: 20171101
 * 
 * Constructor, getters and setters for activities item and checks if expirydate is passed
 * toString method
 * 
 */
>>>>>>> dcbeb5b08b8908ca628441af3497ec409fd96ae3

public class Activities implements Serializable, Comparable<Activities>{
	
	// Variable declarations
	private static final long serialVersionUID = 1L;
	
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	private LocalDate date;
	
	 private String description;
	
	
	// Constructor
	public Activities(LocalDate date, String description) {
		super();
		this.description = description;
		this.date = date;
	}
	
	public Activities(String description) {
		this(LocalDate.now(), description);		
	}


<<<<<<< HEAD
	public LocalDate getLocalDate() {
=======
	// Getter method
	public LocalDate getDate() {
>>>>>>> dcbeb5b08b8908ca628441af3497ec409fd96ae3
		return date;
	}


	// Getter method
	public String getDescription() {
		return description;
	}

	

	// Setter method
	public void setDate(LocalDate date) {
		this.date = date;
	}


	// Setter method
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
