package com.tecacet.movie.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.tecacet.movie.domain.SimpleDirector;

public class SimpleDirectorTest {

	@Test
	public void testEqualsHashCodeToString() {
		Set<String> genres = new HashSet<>(Arrays.asList("Drama", "Comedy"));
		Director director1 = new SimpleDirector("Testonius", 7.3, 8, genres);
		assertEquals("Testonius: 7.30. Movies = 8. Genres = [Comedy, Drama]", director1.toString());

		Director director2 = new SimpleDirector("Testonius2", 7.3, 8, genres);
		assertNotEquals(director1, director2);
		assertFalse(director1.hashCode() == director2.hashCode());
		
		Director director3 = new SimpleDirector("Testonius", 0, 0, new HashSet<>());
		assertEquals(director1, director3);
		assertTrue(director1.hashCode() == director3.hashCode());
	}

}
