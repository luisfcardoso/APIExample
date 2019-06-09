package com.luis.apiexample.resource;

import java.util.List;

import com.luis.apiexample.model.Entry;
import com.luis.apiexample.repository.EntryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entries")
public class EntryResource {

	@Autowired
	private EntryRepository entryRepository;
	
	@GetMapping
	public List<Entry> list() {
		return entryRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Entry> searchById(@PathVariable Long id) {
		Entry entry = entryRepository.findOne(id);
		return entry != null ? ResponseEntity.ok(entry) : ResponseEntity.notFound().build();
	}
	
}