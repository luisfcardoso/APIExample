package com.luis.apiexample.repository.entry;

import com.luis.apiexample.model.Entry;
import com.luis.apiexample.repository.EntryFilter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EntryRepositoryQuery {

	public Page<Entry> filter(EntryFilter entryFilter, Pageable pageable);
	
}