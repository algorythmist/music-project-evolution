package com.tecacet.movie.jpa.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.tecacet.movie.jpa.config.PersistanceConfiguration;
import com.tecacet.movie.jpa.model.EntityPerson;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { PersistanceConfiguration.class })
@Transactional
public class PersonRepositoryTest {

	@Autowired
	private PersonRepository personRepository;
	
	@Test
	public void test() {
		EntityPerson person = new EntityPerson("Tom", false, true);

		personRepository.save(person);
		assertTrue(person.getId() > 0);

		Optional<EntityPerson> found = personRepository.findById(person.getId());
		assertEquals("Tom", found.get().getName());

		List<EntityPerson> allPeople = personRepository.findAll();
		assertEquals(1, allPeople.size());

		personRepository.delete(person);
		allPeople = personRepository.findAll();
		assertEquals(0, allPeople.size());
	}

}
