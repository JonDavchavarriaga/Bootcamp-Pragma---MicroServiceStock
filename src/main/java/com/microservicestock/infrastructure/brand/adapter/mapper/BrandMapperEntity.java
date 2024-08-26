package com.microservicestock.infrastructure.brand.adapter.mapper;

import com.microservicestock.domain.brand.model.Brand;
import com.microservicestock.domain.category.model.Category;
import com.microservicestock.infrastructure.brand.entity.BrandEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapperEntity {
    BrandEntity toEntity(Brand category);
    Category toDomain(BrandEntity brandEntity);
}
