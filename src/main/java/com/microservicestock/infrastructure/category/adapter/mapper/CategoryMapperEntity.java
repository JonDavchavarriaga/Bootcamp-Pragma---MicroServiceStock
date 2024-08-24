package com.microservicestock.infrastructure.category.adapter.mapper;

import com.microservicestock.domain.category.model.Category;
import com.microservicestock.infrastructure.category.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapperEntity {
    CategoryEntity toEntity(Category category);
    Category toDomain(CategoryEntity categoryEntity);
}
