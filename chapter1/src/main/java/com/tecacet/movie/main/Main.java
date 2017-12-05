package com.tecacet.movie.main;

import java.io.IOException;
import java.util.List;

import com.tecacet.movie.model.Director;
import com.tecacet.movie.parser.MovieParser;
import com.tecacet.movie.service.DirectorRatingService;
import com.tecacet.movie.service.ExhaustiveDirectorRatingService;
import com.tecacet.movie.service.InMemoryMovieService;
import com.tecacet.movie.service.MovieService;

public class Main {

	public static void main(String[] args) throws IOException {

		MovieParser movieParser = new MovieParser();
		MovieService movieService = new InMemoryMovieService(movieParser);
		DirectorRatingService ratingService = new ExhaustiveDirectorRatingService(movieService);

		List<Director> directors = ratingService.findTopDirectors(10);
		directors.forEach(d -> System.err.println(d));
	}
}
