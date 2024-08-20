package com.microservicestock.domain.Category.CategoryPort.CategoryPortPersistence;

import com.microservicestock.domain.Category.CategoryModel.Category;

public interface iCategoryPersistencePort {
    void saveCategory(Category category);

    boolean categoryExistsByName(String name);
}
