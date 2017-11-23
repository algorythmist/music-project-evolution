package com.tecacet.movie.domain;

import java.util.Set;

public interface Director {

	String getName();

	double getRating();

	Set<String> getGenres();

	int getMovies();

}