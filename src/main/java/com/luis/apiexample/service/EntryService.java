package com.luis.apiexample.service;

import com.luis.apiexample.model.Entry;
import com.luis.apiexample.model.Person;
import com.luis.apiexample.repository.EntryRepository;
import com.luis.apiexample.repository.PersonRepository;
import com.luis.apiexample.service.exception.InexistentOrInactivePersonException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired 
	private EntryRepository EntryRepository;

	public Entry save(Entry entry) {
        Person person = personRepository.findOne(entry.getPersonId().getId());
        System.out.println(person.toString() + person.getActive().toString());
		if (person == null || (!person.getActive())) {
			throw new InexistentOrInactivePersonException();
		}
		
		return EntryRepository.save(entry);
	}
	
}