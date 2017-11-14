package com.tecacet.movie.service.memory;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tecacet.movie.domain.Movie;
import com.tecacet.movie.domain.Person;
import com.tecacet.movie.service.MovieService;

/**
 * Implementation of the service that compares every director
 * 
 * @author dimitri
 *
 */
public class ExhaustiveDirectorRatingService implements DirectorRatingService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final MovieService movieService;

	public ExhaustiveDirectorRatingService(MovieService movieService) {
		super();
		this.movieService = movieService;
	}

	public List<Director> findTopDirectors(int top) {
		Comparator<Director> ratingComparator = Comparator.comparing(Director::getRating).reversed();
		Comparator<Director> movieComparator = Comparator.comparing(Director::getMovies).reversed();
		Queue<Director> directors = new PriorityQueue<>(ratingComparator.thenComparing(movieComparator));
		logger.info("Comparing {} directors", directors.size());
		for (Person person : movieService.getAllDirectors()) {
			List<Movie> movies = movieService.findMoviesWithDirector(person.getName());
			if (movies.size() < 3) {
				continue;
			}
			OptionalDouble opt = getAverageRating(movies);
			if (!opt.isPresent()) {
				continue;
			}
			Set<String> genres = getGenres(movies);
			Director director = new Director(person.getName(), opt.getAsDouble(),movies.size(), genres);
			directors.add(director);
		}
		return toList(directors, top);
	}

	private List<Director> toList(Queue<Director> directors, int size) {
		int range = directors.size() < size ? directors.size() : size;
		return IntStream.range(0, range).mapToObj(i -> directors.remove()).collect(Collectors.toList());
	}

	private OptionalDouble getAverageRating(List<Movie> movies) {
		return movies.stream().filter(m -> m.getRating().isPresent()).mapToDouble(m -> m.getRating().get()).average();
	}

	private Set<String> getGenres(List<Movie> movies) {
		return movies.stream().map(m -> m.getGenres()).flatMap(gl -> gl.stream()).collect(Collectors.toSet());
	}

}
