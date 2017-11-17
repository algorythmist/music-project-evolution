package com.tecacet.movie.service;

import java.util.List;

import com.tecacet.movie.model.Genre;
import com.tecacet.movie.model.Movie;
import com.tecacet.movie.model.Person;

/**
 * Query the Movie data store for information about movies, people, and genres
 * 
 * @author dimitri
 *
 */
public interface MovieService {

	/**
	 * Get all movies in the data store
	 * @return
	 */
	List<Movie> getAllMovies();

	/**
	 * Get all actors in the data store
	 * @return
	 */
	List<Person> getAllActors();

	/**
	 * Get all directors in the data store
	 * @return
	 */
	List<Person> getAllDirectors();

	/**
	 * Get list of all genres
	 * @return
	 */
	List<Genre> getAllGenres();
	
	/**
	 * Find all movies matching a title. 
	 * The implementation should specify if the search is case-sensitive
	 * and whether it will match a partial title
	 * 
	 * @param name
	 * @return
	 */
	List<Movie> findByTitle(String name);
	
	/**
	 * Find all movies with a specific actor
	 * 
	 * @param actorName
	 * @return
	 */
	List<Movie> findMoviesWithActor(String actorName);

	/**
	 * Find all movies with a specific director
	 * 
	 * @param actorName
	 * @return
	 */
	List<Movie> findMoviesWithDirector(String directorName);
	
	/**
	 * Find all movies within a genre
	 * 
	 * @param genreName
	 * @return
	 */
	List<Movie> findMoviesInGenre(String genreName);
}
