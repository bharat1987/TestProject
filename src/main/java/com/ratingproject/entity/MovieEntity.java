package com.ratingproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIE")
public class MovieEntity {
	
	@Id
	@GeneratedValue(generator = "movieIdGen",strategy = GenerationType.AUTO)
	private long movieId;
	private String movieName;
	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public float getAvg_rating() {
		return avg_rating;
	}
	public void setAvg_rating(float avg_rating) {
		this.avg_rating = avg_rating;
	}
	
	private float avg_rating;
	
}
