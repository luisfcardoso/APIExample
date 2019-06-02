package com.luis.firstapi.firstapi.resource;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luis.firstapi.firstapi.model.Person;
import com.luis.firstapi.firstapi.repository.PersonRepository;

@RestController
@RequestMapping("/people")
public class PersonResource {

	@Autowired
	private PersonRepository personRepository;
	
	@PostMapping
	public ResponseEntity<Person> criar(@Valid @RequestBody Person person, HttpServletResponse response) {
		Person savePerson = personRepository.save(person);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(savePerson.getId()).toUri();
			response.setHeader("Location", uri.toASCIIString());
			
			return ResponseEntity.created(uri).body(savePerson);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Person> searchById(@PathVariable Long id) {
		Person person = personRepository.findOne(id);
		 return person != null ? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
	}
	
}