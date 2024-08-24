package com.microservicestock.domain.category.usecase;

import com.microservicestock.domain.category.model.Category;
import com.microservicestock.domain.category.port.persistence.ICategoryPersistencePort;
import com.microservicestock.domain.category.port.service.ICategoryServicePort;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.util.comparator.Comparators;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(Category category) {
        categoryPersistencePort.saveCategory(category);
    }
    @Override
    public boolean categoryExistsByName(String name) {
        return categoryPersistencePort.categoryExistsByName(name);
    }
    @Override
    public List<Category> getAllCategories() {
        return categoryPersistencePort.getAllCategories();
    }
    public List<Category> getCategoriesSortedAndPaged(int page, int size, boolean ascending) {
        List<Category> categories = getAllCategories();

        if (ascending) {
            categories = categories.stream()
                    .sorted(Comparator.comparing(Category::getName))
                    .collect(Collectors.toList());
        } else {
            categories = categories.stream()
                    .sorted(Comparator.comparing(Category::getName).reversed())
                    .collect(Collectors.toList());
        }

        int start = Math.min(page * size, categories.size());
        int end = Math.min(start + size, categories.size());

        return categories.subList(start, end);
    }


}
