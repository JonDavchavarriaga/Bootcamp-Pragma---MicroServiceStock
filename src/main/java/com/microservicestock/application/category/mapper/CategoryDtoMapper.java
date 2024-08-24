package com.microservicestock.application.category.mapper;
import com.microservicestock.application.category.dto.CategoryDto;
import com.microservicestock.domain.category.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryDtoMapper {

    Category toDomain(CategoryDto categoryDto);
    CategoryDto toDto(Category category);
}
