package com.microservicestock.infrastructure.infrastructureCategory.adapter.adapterCategoryEntity;

import com.microservicestock.domain.Category.CategoryModel.Category;
import com.microservicestock.domain.Category.CategoryModel.CategoryConstants.CategoryConstant;
import com.microservicestock.domain.Category.CategoryPort.CategoryPortPersistence.iCategoryPersistencePort;
import com.microservicestock.infrastructure.infrastructureCategory.adapter.adapterMapper.CategoryMapperEntity;
import com.microservicestock.infrastructure.infrastructureCategory.adapter.persistence.iCategoryRepository;
import com.microservicestock.infrastructure.infrastructureCategory.exception.CategoryExistsException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryAdapterEntity implements iCategoryPersistencePort {
    private final iCategoryRepository categoryRepository;
    private final CategoryMapperEntity categoryMapperEntity;


    @Override
    public void saveCategory(Category category) {
        if (categoryRepository.existsByName(category.getName())) {
            throw new CategoryExistsException(CategoryConstant.CATEGORY_ALREADY_EXISTS);
        }
        categoryRepository.save(categoryMapperEntity.toEntity(category));
    }
    @Override
    public boolean categoryExistsByName(String name) {
        return categoryRepository.existsByName(name);
    }
}
