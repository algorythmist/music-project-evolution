package com.tecacet.movie.service.memory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import com.tecacet.movie.config.ApplicationConfiguration;
import com.tecacet.movie.domain.Director;
import com.tecacet.movie.service.DirectorRatingService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ApplicationConfiguration.class })
public class ComparativeDirectorRatingServiceTest {

	@Autowired
	private SerialDirectorRatingService serialDirectorRatingService;

	@Autowired
	private Parallel8DirectorRatingService parallel8DirectorRatingService;

	@Autowired
	private ParallelExecutorDirectorRatingService parallelExecutorDirectorRatingService;

	@Test
	public void findTopDirectorsSerial() throws IOException {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		findTopDirectors(serialDirectorRatingService);
		stopWatch.stop();
		System.out.println("Time to execute serial service = " + stopWatch.getTotalTimeMillis());
	}

	@Test
	public void findTopDirectorsParallel8() throws IOException {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		findTopDirectors(parallel8DirectorRatingService);
		stopWatch.stop();
		System.out.println("Time to execute Java 8 parallel streams = " + stopWatch.getTotalTimeMillis());
	}

	@Test
	public void findTopDirectorsParallelExecutor() throws IOException {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		findTopDirectors(parallelExecutorDirectorRatingService);
		stopWatch.stop();
		System.out.println("Time to execute thread pool = " + stopWatch.getTotalTimeMillis());
	}

	private void findTopDirectors(DirectorRatingService ratingService) {
		List<? extends Director> directors = ratingService.findTopDirectors(10);
		assertEquals(10, directors.size());

		// Test that directors are in the correct order
		double lastRating = directors.get(0).getRating();
		for (int i = 1; i < 5; i++) {
			double rating = directors.get(i).getRating();
			assertTrue(rating <= lastRating);
			lastRating = rating;
		}

		Director director = directors.get(0);
		assertEquals("Charles Chaplin", director.getName());
		assertEquals(8.50, director.getRating(), 0.01);
		assertEquals(4, director.getMovies());
		assertEquals("[Comedy, Drama, Family, Romance, War]", director.getGenres().toString());

	}

}
