package com.microservicestock.infrastructure.category.adapter.entity;

import com.microservicestock.domain.category.model.Category;
import com.microservicestock.domain.category.model.categoryConstants.categoryConstant;
import com.microservicestock.domain.category.port.persistence.ICategoryPersistencePort;
import com.microservicestock.infrastructure.category.adapter.mapper.CategoryMapperEntity;
import com.microservicestock.infrastructure.category.adapter.persistence.ICategoryRepository;
import com.microservicestock.infrastructure.category.exception.CategoryExistsException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryAdapterEntity implements ICategoryPersistencePort {
    private final ICategoryRepository categoryRepository;
    private final CategoryMapperEntity categoryMapperEntity;


    @Override
    public void saveCategory(Category category) {
        if (categoryRepository.existsByName(category.getName())) {
            throw new CategoryExistsException(categoryConstant.CATEGORY_ALREADY_EXISTS);
        }
        categoryRepository.save(categoryMapperEntity.toEntity(category));
    }
    @Override
    public boolean categoryExistsByName(String name) {
        return categoryRepository.existsByName(name);
    }
}
