package com.luis.apiexample.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.luis.apiexample.event.CreatedResourceEvent;
import com.luis.apiexample.model.Category;
import com.luis.apiexample.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ApplicationEventPublisher publisher;
    
    @GetMapping
    public List<Category> list() {
        return categoryRepository.findAll();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Category> criar(@Valid @RequestBody Category category, HttpServletResponse response) {
        Category savedCategory = categoryRepository.save(category);

        publisher.publishEvent(new CreatedResourceEvent(this, response, savedCategory.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> searchById(@PathVariable Long id) {
        Category category = categoryRepository.findOne(id);

        return category != null ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
    }
}