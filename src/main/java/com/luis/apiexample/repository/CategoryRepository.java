package com.luis.apiexample.repository;

import com.luis.apiexample.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}