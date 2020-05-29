package com.ratingproject.service;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratingproject.entity.CustomerEntity;
import com.ratingproject.entity.MovieEntity;
import com.ratingproject.entity.Rating;
import com.ratingproject.model.RatingInfo;
import com.ratingproject.repository.CustomerRepository;
import com.ratingproject.repository.MovieRepository;
import com.ratingproject.repository.RatingRepository;

@Service
public class MovieRatingService {
	
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	
	@Autowired
	RatingRepository ratingRepo;
	
	@Autowired
	MovieRepository movieRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	
	public void addRating(String customerId, int ratingValue, long movieId){
		logger.info("Inside add rating service");
		Rating rating=new Rating(customerId,movieId,ratingValue);
		ratingRepo.save(rating);		
		
	}

	public List<String> getHighestRatedMovie() {
		logger.info("Inside getHighestRatedMovie service");
		List<Rating> ratingList=ratingRepo.findAll();
		
		Map<Long, Double> averageRatings=ratingList.stream().collect(Collectors.groupingBy(Rating::getMovieId,Collectors.averagingDouble(Rating::getRatingValue)));
		
		double max =Collections.max(averageRatings.values());
		
		List<Long> movieIds = averageRatings.entrySet().stream()
			    .filter(entry -> entry.getValue() == max)
			    .map(entry -> entry.getKey())
			    .collect(Collectors.toList());
		logger.info("Inside getHighestRatedMovie service - list of movie Ids "+movieIds.toString());
		return movieRepo.findByMovieIdIn(movieIds);
		
	}

	public RatingInfo getCustomerMovieRatingDetails(String customerId) {
		List<Rating> custRatingList=ratingRepo.findByCustId(customerId);
		List<Long> movieList = custRatingList.stream().map(Rating::getMovieId).collect(Collectors.toList());
		String custAvgRatingTemp=null,movieAvgRatingTemp=null;
		
		OptionalDouble customerAverageRating=custRatingList.stream()
	    .mapToDouble(Rating::getRatingValue)
	    .average();
		
		
		List<Rating> moviesRatingList=ratingRepo.findByMovieIdIn(movieList);
		OptionalDouble averageMovieRating=moviesRatingList.stream()
			    .mapToDouble(Rating::getRatingValue)
			    .average();
		
		
		
		if (customerAverageRating.isPresent()) {
			custAvgRatingTemp=new DecimalFormat("#0.00").format(customerAverageRating.getAsDouble());
		}
		if (averageMovieRating.isPresent()) {
			movieAvgRatingTemp=new DecimalFormat("#0.00").format(averageMovieRating.getAsDouble());
		}
		
		logger.info("Avg ratings " +custAvgRatingTemp+" "+movieAvgRatingTemp);
		Optional<CustomerEntity> customer=customerRepo.findById(customerId);
		RatingInfo custRatingInfo=new RatingInfo(customerId,customer.get().getFirstName(),customer.get().getLastName(),custAvgRatingTemp,movieAvgRatingTemp);
		
		return custRatingInfo;
	}

}
