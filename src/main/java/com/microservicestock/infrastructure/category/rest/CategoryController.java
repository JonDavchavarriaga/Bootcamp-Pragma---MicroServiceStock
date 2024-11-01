package com.microservicestock.infrastructure.category.rest;


import com.microservicestock.application.category.dto.CategoryDto;
import com.microservicestock.application.category.handler.ICategoryHandler;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final ICategoryHandler categoryHandler;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')") // Solo administradores pueden crear categorías
    public ResponseEntity<Void> saveCategory(@RequestBody CategoryDto categoryDto) {
        categoryHandler.saveCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    @PermitAll // Ruta pública
    public ResponseEntity<List<CategoryDto>> getCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "true") boolean ascending) {

        List<CategoryDto> categories = categoryHandler.getCategoriesSortedAndPaged(page, size, ascending);
        return ResponseEntity.ok(categories);
    }
}

