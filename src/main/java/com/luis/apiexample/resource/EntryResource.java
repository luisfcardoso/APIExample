package com.luis.apiexample.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.luis.apiexample.event.CreatedResourceEvent;
import com.luis.apiexample.model.Entry;
import com.luis.apiexample.repository.EntryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entries")
public class EntryResource {

	@Autowired
    private EntryRepository entryRepository;
    
    @Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Entry> list() {
		return entryRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Entry> searchById(@PathVariable Long id) {
		Entry entry = entryRepository.findOne(id);
		return entry != null ? ResponseEntity.ok(entry) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
	public ResponseEntity<Entry> criar(@Valid @RequestBody Entry entry, HttpServletResponse response) {
		Entry savedEntry = entryRepository.save(entry);
		publisher.publishEvent(new CreatedResourceEvent(this, response, savedEntry.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(savedEntry);
	}
	
}