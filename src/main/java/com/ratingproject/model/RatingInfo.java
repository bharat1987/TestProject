package com.ratingproject.model;

public class RatingInfo {

	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCustomerAverageRating() {
		return customerAverageRating;
	}
	public void setCustomerAverageRating(String customerAverageRating) {
		this.customerAverageRating = customerAverageRating;
	}
	public String getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(String averageRating) {
		this.averageRating = averageRating;
	}
	private String firstName;
	private String lastName;
	private String customerAverageRating;
	private String averageRating;
	public RatingInfo(String id, String firstName, String lastName, String customerAverageRating,
			String averageRating) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerAverageRating = customerAverageRating;
		this.averageRating = averageRating;
	}
	public RatingInfo(){}
}
