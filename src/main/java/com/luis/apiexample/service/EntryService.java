package com.luis.apiexample.service;

import com.luis.apiexample.model.Entry;
import com.luis.apiexample.model.Person;
import com.luis.apiexample.repository.EntryRepository;
import com.luis.apiexample.repository.PersonRepository;
import com.luis.apiexample.service.InexistentOrInactivePersonException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired 
	private EntryRepository entryRepository;

	public Entry saveeEntry(Entry entry) {
        Person person = personRepository.findOne(entry.getPersonId().getId());

		if (person == null || (!person.getActive())) {
			throw new InexistentOrInactivePersonException();
		}
		
		return entryRepository.save(entry);
	}
	
}