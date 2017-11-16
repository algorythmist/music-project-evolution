package com.tecacet.movie.jpa.service;

import java.util.List;

import com.tecacet.movie.domain.Genre;
import com.tecacet.movie.domain.Movie;
import com.tecacet.movie.domain.Person;
import com.tecacet.movie.jpa.repository.MovieRepository;
import com.tecacet.movie.service.MovieService;

public class RepositoryMovieService implements MovieService {

	private final MovieRepository movieRepository;
	
	public RepositoryMovieService(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getAllActors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getAllDirectors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Genre> getAllGenres() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> findByTitle(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> findMoviesWithActor(String actorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> findMoviesWithDirector(String directorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> findMoviesInGenre(String genreName) {
		// TODO Auto-generated method stub
		return null;
	}

}
