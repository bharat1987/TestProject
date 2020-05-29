package com.ratingproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RATING")
public class Rating {
	
	
	@Id
	@GeneratedValue(generator = "ratingIdGen",strategy = GenerationType.AUTO)
	private long ratingId;
	
	private String custId;
	private long movieId;
	private int ratingValue;	
	
	public Rating() {}
	public Rating(String custId, long movieId, int ratingValue) {
		super();
		this.custId = custId;
		this.movieId = movieId;
		this.ratingValue = ratingValue;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	public int getRatingValue() {
		return ratingValue;
	}
	public void setRatingValue(int ratingValue) {
		this.ratingValue = ratingValue;
	}
	
	

}
