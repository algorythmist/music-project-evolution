package com.tecacet.movie.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecacet.movie.domain.Movie;
import com.tecacet.movie.jpa.model.EntityGenre;
import com.tecacet.movie.jpa.model.EntityMovie;
import com.tecacet.movie.jpa.model.EntityPerson;
import com.tecacet.movie.jpa.repository.GenreRepository;
import com.tecacet.movie.jpa.repository.MovieRepository;
import com.tecacet.movie.jpa.repository.PersonRepository;
import com.tecacet.movie.service.MovieService;

@Service
public class RepositoryMovieService implements MovieService {

	private final MovieRepository movieRepository;
	private final PersonRepository personRepository;
	private final GenreRepository genreRepository;

	@Autowired
	public RepositoryMovieService(MovieRepository movieRepository, PersonRepository personRepository,
			GenreRepository genreRepository) {
		super();
		this.movieRepository = movieRepository;
		this.personRepository = personRepository;
		this.genreRepository = genreRepository;
	}

	@Override
	public List<EntityMovie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public List<EntityPerson> getAllActors() {
		return personRepository.findAllActors();
	}

	@Override
	public List<EntityPerson> getAllDirectors() {
		return personRepository.findAllDirectors();
	}

	@Override
	public List<EntityGenre> getAllGenres() {
		return genreRepository.findAll();
	}

	@Override
	public List<EntityMovie> findByTitle(String title) {
		return movieRepository.findByTitleContainingIgnoreCase(title);
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
