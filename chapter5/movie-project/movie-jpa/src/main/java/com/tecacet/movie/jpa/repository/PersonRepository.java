package com.tecacet.movie.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tecacet.movie.jpa.model.EntityPerson;

public interface PersonRepository extends CrudRepository<EntityPerson, Long> {

	List<EntityPerson> findAll();
}
