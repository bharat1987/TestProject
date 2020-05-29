package com.ratingproject.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratingproject.model.RatingInfo;
import com.ratingproject.service.MovieRatingService;

@RestController
@RequestMapping("/api/rest")
public class MovieRatingController {
	
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	MovieRatingService mrService;
	
	@PutMapping(value="/customer/{customer.id}/rate/{rating}/movie/{movie.id}")
	public void addMovieRating(@PathVariable("customer.id") String customerId,@PathVariable("rating") int rating, @PathVariable("movie.id") long movieId) {
		logger.info("Add rating for movie - controller");
		mrService.addRating(customerId,rating,movieId);
	}
	
	@GetMapping(value="/highestRatedMovie")
	public List<String>  getHighestRatedMovie() {
		logger.info("In getHighestRatedMovie - controller");
		return mrService.getHighestRatedMovie();
	}
	
	@GetMapping(value="/getCustomerMovieRatingDetails/{customer.id}")
	public RatingInfo  getCustomerMovieRatingDetails(@PathVariable("customer.id") String customerId) {
		logger.info("In getCustomerMovieRatingDetails - controller");
		return mrService.getCustomerMovieRatingDetails(customerId);
	}

}
