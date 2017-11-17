package com.tecacet.movie.main;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tecacet.movie.parser.MovieParser;
import com.tecacet.movie.service.Director;
import com.tecacet.movie.service.DirectorRatingService;
import com.tecacet.movie.service.ExhaustiveDirectorRatingService;
import com.tecacet.movie.service.InMemoryMovieService;
import com.tecacet.movie.service.MovieService;

public class Main {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws IOException {

		MovieParser movieParser = new MovieParser();
		MovieService movieService = new InMemoryMovieService(movieParser);
		DirectorRatingService ratingService = new ExhaustiveDirectorRatingService(movieService);

		List<Director> directors = ratingService.findTopDirectors(10);
		directors.forEach(d -> LOGGER.info(d.toString()));
	}
}
