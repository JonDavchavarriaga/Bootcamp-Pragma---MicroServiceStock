package com.microservicestock.application.Category.handler;

import com.microservicestock.application.Category.dto.CategoryDto;
import com.microservicestock.application.Category.mapper.iCategoryDtoMapper;
import com.microservicestock.domain.Category.CategoryModel.Category;
import com.microservicestock.domain.Category.CategoryPort.CategoryPortService.iCategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryHandler implements iCategoryHandler {
    private final iCategoryServicePort categoryServicePort;
    private final iCategoryDtoMapper categoryDtoMapper;


    @Override
    public void saveCategory(CategoryDto categoryDto) {
        Category category = categoryDtoMapper.toDomain(categoryDto);
        categoryServicePort.saveCategory(category);
    }
}
