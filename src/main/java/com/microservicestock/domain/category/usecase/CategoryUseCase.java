package com.microservicestock.domain.category.usecase;

import com.microservicestock.domain.category.model.Category;
import com.microservicestock.domain.category.port.persistence.ICategoryPersistencePort;
import com.microservicestock.domain.category.port.service.ICategoryServicePort;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(Category category) {
        categoryPersistencePort.saveCategory(category);
    }
}
