package kalle;

import java.io.Serializable;
import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/*
 * @author: Lia Afework, Anna Thompson, Tommy Steger
 * @date: 20171101
 * 
 * Constructor, getters and setters for activities item and checks if expirydate is passed
 * toString method
 * 
 */
public class Activities implements Serializable, Comparable<Activities>{
	
	// Variable declarations
	private static final long serialVersionUID = 1L;
	
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	private LocalDate date;
	
	 private String description;
	
	
	public Activities(LocalDate date, String description) {
		super();
		this.date = date;
		this.description = description;
	}


	
	public Activities(String description) {
		this(LocalDate.now(), description);		
	}


	

	public LocalDate getLocalDate() {
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
