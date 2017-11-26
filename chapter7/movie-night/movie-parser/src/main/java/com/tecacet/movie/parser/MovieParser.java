package com.tecacet.movie.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Parse a JSON file containing movie information
 * @see JsonMovie
 * 
 * @author dimitri
 *
 */
public class MovieParser {
	
	private final ObjectMapper objectMapper = new ObjectMapper();

	public List<JsonMovie> parse(String filename) throws IOException {
		InputStream is = ClassLoader.getSystemResourceAsStream(filename);
		return objectMapper.readValue(is, new TypeReference<List<JsonMovie>>(){});
	}
}
