package com.microservicestock.domain.Category.CategoryPort.CategoryPortService;
import com.microservicestock.domain.Category.CategoryModel.Category;

public interface iCategoryServicePort {
    void saveCategory(Category category);
}
