package com.tecacet.movie.service;

import java.util.List;

public interface DirectorRatingService {

	List<Director> findTopDirectors(int top);
	
}
