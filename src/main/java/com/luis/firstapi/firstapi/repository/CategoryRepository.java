package com.luis.firstapi.firstapi.repository;

import com.luis.firstapi.firstapi.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}