package com.luis.apiexample.repository.entry;

import java.util.List;

import com.luis.apiexample.model.Entry;
import com.luis.apiexample.repository.EntryFilter;

public interface EntryRepositoryQuery {

	public List<Entry> filter(EntryFilter entryFilter);
	
}