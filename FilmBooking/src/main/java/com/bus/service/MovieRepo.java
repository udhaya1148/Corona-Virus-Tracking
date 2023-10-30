package com.bus.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bus.beans.MovieDetails;

public interface MovieRepo extends JpaRepository<MovieDetails, Long> {

	
	@Transactional
    void deleteByMovieId(Long movieId);

    MovieDetails findByMovieId(Long movieId);
    @Transactional
    void deleteByMovieName(String movieName);

    MovieDetails findByMovieName(String movieName);
}
