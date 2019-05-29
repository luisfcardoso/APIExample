package com.luis.firstapi.firstapi.resource;

import java.util.List;

import com.luis.firstapi.firstapi.model.Category;
import com.luis.firstapi.firstapi.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> list() {
        return categoryRepository.findAll();
    }
}