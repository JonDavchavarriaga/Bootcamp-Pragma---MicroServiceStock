package com.microservicestock.infrastructure.infrastructureCategory.adapter.adapterMapper;

import com.microservicestock.domain.Category.CategoryModel.Category;
import com.microservicestock.infrastructure.infrastructureCategory.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapperEntity {
    CategoryEntity toEntity(Category category);
}
