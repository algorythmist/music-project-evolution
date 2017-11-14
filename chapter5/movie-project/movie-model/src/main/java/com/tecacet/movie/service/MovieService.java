package com.tecacet.movie.service;

import java.util.List;

import com.tecacet.movie.domain.Genre;
import com.tecacet.movie.domain.Movie;
import com.tecacet.movie.domain.Person;

public interface MovieService {

	List<Movie> getAllMovies();

	List<Person> getAllActors();

	List<Person> getAllDirectors();

	List<Genre> getAllGenres();
	
	List<Movie> findByTitle(String name);
	
	List<Movie> findMoviesWithActor(String actorName);

	List<Movie> findMoviesWithDirector(String directorName);
	
	List<Movie> findMoviesInGenre(String genreName);
}
