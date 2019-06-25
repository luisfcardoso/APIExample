package com.luis.apiexample.resource;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.luis.apiexample.service.InexistentOrInactivePersonException;
import com.luis.apiexample.event.CreatedResourceEvent;
import com.luis.apiexample.exceptionhandler.APIExceptionHandler.Error;
import com.luis.apiexample.model.Entry;
import com.luis.apiexample.repository.EntryFilter;
import com.luis.apiexample.repository.EntryRepository;
import com.luis.apiexample.service.EntryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entries")
public class EntryResource {

	@Autowired
	private EntryRepository entryRepository;
	
	@Autowired
    private EntryService entryService;
    
    @Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
    private MessageSource messageSource;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_SEARCH_ENTRY')")
	public Page<Entry> search(EntryFilter entryFilter, Pageable pageable) {
		return entryRepository.filter(entryFilter, pageable);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_SEARCH_ENTRY')")
	public ResponseEntity<Entry> searchById(@PathVariable Long id) {
		Entry entry = entryRepository.findOne(id);
		return entry != null ? ResponseEntity.ok(entry) : ResponseEntity.notFound().build();
    }
    
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_REGISTER_ENTRY')")
	public ResponseEntity<Entry> create(@Valid @RequestBody Entry entry, HttpServletResponse response) {
		Entry savedEntry = entryService.saveeEntry(entry);
		publisher.publishEvent(new CreatedResourceEvent(this, response, savedEntry.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(savedEntry);
	}
	
	@ExceptionHandler({InexistentOrInactivePersonException.class})
	public ResponseEntity<Object> handleInexistentOrInactivePersonException(InexistentOrInactivePersonException ex) {
		String userMessage = messageSource.getMessage("person.inexistent-or-inactive", null, LocaleContextHolder.getLocale());
		String devMessage = ex.toString();
		List<Error> errors = Arrays.asList(new Error(userMessage, devMessage));

		return ResponseEntity.badRequest().body(errors);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_ENTRY')")
	public void remove(@PathVariable Long id) {
		entryRepository.delete(id);
	}
}