package com.tecacet.movie.model;

/**
 * A person participating in a movie as Director or Actor
 * 
 * @author dimitri
 *
 */
public interface Person {

	String getName();
	
	boolean isActor();
	
	boolean isDirector();
}
