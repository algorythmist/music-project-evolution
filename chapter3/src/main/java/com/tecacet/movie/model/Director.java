package com.tecacet.movie.model;

import java.util.Set;
import java.util.TreeSet;

public class Director {

	private final String name;
	private final double rating;
	private final int movies;
	private final Set<String> genres;

	public Director(String name, double rating, int movies, Set<String> genres) {
		super();
		this.name = name;
		this.rating = Math.round(rating * 100) / 100.;
		this.movies = movies;
		this.genres = new TreeSet<>(genres);
	}

	public String getName() {
		return name;
	}

	public double getRating() {
		return rating;
	}

	public Set<String> getGenres() {
		return genres;
	}

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
		if (!(other instanceof Director)) {
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
