package com.ratingproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ratingproject.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long>{

	List<Rating> findByCustId(String customerId);

	List<Rating> findByMovieIdIn(List<Long> movieList);

}
