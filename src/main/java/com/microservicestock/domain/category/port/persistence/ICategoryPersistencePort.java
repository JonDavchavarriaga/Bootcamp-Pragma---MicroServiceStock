package com.microservicestock.domain.category.port.persistence;

import com.microservicestock.domain.category.model.Category;

import java.util.List;

public interface ICategoryPersistencePort {
    void saveCategory(Category category);

    boolean categoryExistsByName(String name);

    List<Category> getAllCategories();
}
