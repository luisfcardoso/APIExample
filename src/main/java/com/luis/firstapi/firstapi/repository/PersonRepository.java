package com.luis.firstapi.firstapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luis.firstapi.firstapi.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}