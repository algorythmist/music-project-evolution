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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecacet.movie.domain.SimpleDirector;
import com.tecacet.movie.domain.Movie;
import com.tecacet.movie.domain.Person;
import com.tecacet.movie.service.DirectorRatingService;
import com.tecacet.movie.service.MovieService;

/**
 * Implementation of the service that compares every director
 * 
 * @author dimitri
 *
 */
@Service
public class SerialDirectorRatingService implements DirectorRatingService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final MovieService movieService;

	@Autowired
	public SerialDirectorRatingService(MovieService movieService) {
		super();
		this.movieService = movieService;
	}

	public List<SimpleDirector> findTopDirectors(int top) {
		Comparator<SimpleDirector> ratingComparator = Comparator.comparing(SimpleDirector::getRating).reversed();
		Comparator<SimpleDirector> movieComparator = Comparator.comparing(SimpleDirector::getMovies).reversed();
		Queue<SimpleDirector> directors = new PriorityQueue<>(ratingComparator.thenComparing(movieComparator));
		logger.info("Comparing {} directors", directors.size());
		for (Person person : movieService.getAllDirectors()) {
			List<? extends Movie> movies = movieService.findMoviesWithDirector(person.getName());
			if (movies.size() < 3) {
				continue;
			}
			OptionalDouble opt = getAverageRating(movies);
			if (!opt.isPresent()) {
				continue;
			}
			Set<String> genres = getGenres(movies);
			SimpleDirector director = new SimpleDirector(person.getName(), opt.getAsDouble(),movies.size(), genres);
			directors.add(director);
		}
		return toList(directors, top);
	}

	private List<SimpleDirector> toList(Queue<SimpleDirector> directors, int size) {
		int range = directors.size() < size ? directors.size() : size;
		return IntStream.range(0, range).mapToObj(i -> directors.remove()).collect(Collectors.toList());
	}

	private OptionalDouble getAverageRating(List<? extends Movie> movies) {
		return movies.stream().filter(m -> m.getRating().isPresent()).mapToDouble(m -> m.getRating().get()).average();
	}

	private Set<String> getGenres(List<? extends Movie> movies) {
		return movies.stream().map(m -> m.getGenres()).flatMap(gl -> gl.stream()).map(g -> g.getName()).collect(Collectors.toSet());
	}

}
