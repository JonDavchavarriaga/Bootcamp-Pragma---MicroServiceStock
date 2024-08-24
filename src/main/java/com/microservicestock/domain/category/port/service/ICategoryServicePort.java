package com.microservicestock.domain.category.port.service;
import com.microservicestock.domain.category.model.Category;

public interface ICategoryServicePort {
    void saveCategory(Category category);
    boolean categoryExistsByName(String name);
}
