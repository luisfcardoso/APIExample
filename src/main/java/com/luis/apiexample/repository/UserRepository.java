package com.luis.apiexample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luis.apiexample.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByEmail(String email);
	
}