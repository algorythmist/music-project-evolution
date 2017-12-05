package com.tecacet.movie.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.tecacet.movie.model.Director;
import com.tecacet.movie.parser.JsonMovie;
import com.tecacet.movie.parser.MovieParser;

public class ExhaustiveDirectorRatingServiceTest {

	@Test
	public void findTopDirectors() throws IOException {
		MovieParser movieParser = new MovieParser();
		MovieService movieService = new InMemoryMovieService(movieParser);
		DirectorRatingService ratingService = new ExhaustiveDirectorRatingService(movieService);

		List<Director> directors = ratingService.findTopDirectors(10);
		assertEquals(10, directors.size());

		// Test that directors are in the correct order
		double lastRating = directors.get(0).getRating();
		for (int i = 1; i < 5; i++) {
			double rating = directors.get(i).getRating();
			assertTrue(rating <= lastRating);
			lastRating = rating;
		}
	}
	
	@Test
	public void tooManyDirectors() throws IOException {
		MovieParser movieParser = new MovieParser();
		MovieService movieService = new InMemoryMovieService(movieParser);
		DirectorRatingService ratingService = new ExhaustiveDirectorRatingService(movieService);

		List<Director> directors = ratingService.findTopDirectors(2500);
		assertEquals(528, directors.size());
		
	}
	
	@Test
	public void noDirectors() throws IOException {
		MovieParser movieParser = new MovieParser();
		MovieService movieService = new InMemoryMovieService(movieParser);
		DirectorRatingService ratingService = new ExhaustiveDirectorRatingService(movieService);

		List<Director> directors = ratingService.findTopDirectors(0);
		assertEquals(0, directors.size());
	}
	
	@Test
	public void noMoviesInDatabase() throws IOException {
		MovieParser movieParser = new MovieParser() {
			public List<JsonMovie> parse(String filename) {
				return Collections.emptyList();
			}
		};
		MovieService movieService = new InMemoryMovieService(movieParser);
		DirectorRatingService ratingService = new ExhaustiveDirectorRatingService(movieService);
		List<Director> directors = ratingService.findTopDirectors(10);
		assertEquals(0, directors.size());
	}

}
