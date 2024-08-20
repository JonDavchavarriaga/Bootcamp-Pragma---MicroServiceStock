package com.microservicestock.application.Category.mapper;
import com.microservicestock.application.Category.dto.CategoryDto;
import com.microservicestock.domain.Category.CategoryModel.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface iCategoryDtoMapper {

    Category toDomain(CategoryDto categoryDto);

}
