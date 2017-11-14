package com.tecacet.movie.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tecacet.movie.jpa.model.EntityMovie;

public interface MovieRepository extends CrudRepository<EntityMovie, Long> {

	List<EntityMovie> findAll();

}
