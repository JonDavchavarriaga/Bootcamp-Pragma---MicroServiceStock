package com.microservicestock.domain.Category.CategoryUseCases;

import com.microservicestock.domain.Category.CategoryModel.Category;
import com.microservicestock.domain.Category.CategoryPort.CategoryPortPersistence.iCategoryPersistencePort;
import com.microservicestock.domain.Category.CategoryPort.CategoryPortService.iCategoryServicePort;

public class CategoryUseCase implements iCategoryServicePort {

    private final iCategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(iCategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(Category category) {
        categoryPersistencePort.saveCategory(category);
    }
}
