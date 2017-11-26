package com.tecacet.movie.domain;

import java.util.Set;
import java.util.TreeSet;

public class SimpleDirector implements Director {

	private final String name;
	private final double rating;
	private final int movies;
	private final Set<String> genres;

	public SimpleDirector(String name, double rating, int movies, Set<String> genres) {
		super();
		this.name = name;
		this.rating = Math.round(rating * 100) / 100.;
		this.movies = movies;
		this.genres = new TreeSet<>(genres);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getRating() {
		return rating;
	}

	@Override
	public Set<String> getGenres() {
		return genres;
	}

	@Override
	public int getMovies() {
		return movies;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SimpleDirector)) {
			return false;
		}
		Director director = (Director) other;
		return name.equals(director.getName());
	}

	@Override
	public String toString() {
		return String.format("%s: %.2f. Movies = %d. Genres = %s", getName(), getRating(), getMovies(), getGenres());
	}
}
