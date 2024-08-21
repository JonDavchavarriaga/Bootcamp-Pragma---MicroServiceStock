package com.microservicestock.domain.category.port.persistence;

import com.microservicestock.domain.category.model.Category;

public interface ICategoryPersistencePort {
    void saveCategory(Category category);

    boolean categoryExistsByName(String name);
}
