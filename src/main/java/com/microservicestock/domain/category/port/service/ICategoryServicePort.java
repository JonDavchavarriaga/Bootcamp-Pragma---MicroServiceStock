package com.microservicestock.domain.category.port.service;
import com.microservicestock.domain.category.model.Category;
import java.util.List;


public interface ICategoryServicePort {
    void saveCategory(Category category);
    boolean categoryExistsByName(String name);
    List<Category>getAllCategories();
    List<Category> getCategoriesSortedAndPaged(int page, int size, boolean ascending);
    Category getCategoryById(Long id);
}
