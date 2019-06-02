package com.luis.apiexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luis.apiexample.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}