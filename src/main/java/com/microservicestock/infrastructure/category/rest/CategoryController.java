package com.microservicestock.infrastructure.category.rest;


import com.microservicestock.application.category.dto.CategoryDto;
import com.microservicestock.application.category.handler.ICategoryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final ICategoryHandler categoryHandler;

    @PostMapping
public ResponseEntity<Void> saveCategory(@RequestBody CategoryDto categoryDto) {
    categoryHandler.saveCategory(categoryDto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
}
}

