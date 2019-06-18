package com.luis.apiexample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luis.apiexample.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	public Optional<Users> findByEmail(String email);
	
}