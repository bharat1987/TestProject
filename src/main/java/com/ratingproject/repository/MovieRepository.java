package com.ratingproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ratingproject.entity.MovieEntity;


public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
	
	@Query(value = "select m.movieName from MovieEntity m where m.movieId in (:movieIds)")
	List<String> findByMovieIdIn(@Param("movieIds")List<Long> movieIds);

}
