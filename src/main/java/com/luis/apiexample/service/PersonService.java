package com.luis.apiexample.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.luis.apiexample.model.Person;
import com.luis.apiexample.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	public Person update(Long id, Person person) {
		Person savedPerson = personRepository.findOne(id);
		if (savedPerson == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(person, savedPerson, "id");
		return personRepository.save(savedPerson);
	}
	
}