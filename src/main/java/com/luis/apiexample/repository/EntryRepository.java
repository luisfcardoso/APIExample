package com.luis.apiexample.repository;

import com.luis.apiexample.model.Entry;
import com.luis.apiexample.repository.entry.EntryRepositoryQuery;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Long>, EntryRepositoryQuery {

}