package com.tecacet.movie.service;

import java.util.List;

import com.tecacet.movie.model.Director;

public interface DirectorRatingService {

	List<Director> findTopDirectors(int top);
	
}
