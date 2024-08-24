package com.microservicestock.application.category.handler;

import com.microservicestock.application.category.dto.CategoryDto;
import com.microservicestock.application.category.mapper.CategoryDtoMapper;
import com.microservicestock.domain.category.model.Category;
import com.microservicestock.domain.category.model.categoryConstants.categoryConstant;
import com.microservicestock.domain.category.port.service.ICategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryHandler implements ICategoryHandler {
    private final ICategoryServicePort categoryServicePort;
    private final CategoryDtoMapper categoryDtoMapper;


    @Override
    public void saveCategory(CategoryDto categoryDto) {
        Category category = categoryDtoMapper.toDomain(categoryDto);
        if (!categoryServicePort.categoryExistsByName(category.getName())) {
            categoryServicePort.saveCategory(category);
        }else{
            throw new IllegalArgumentException(categoryConstant.CATEGORY_ALREADY_EXISTS);
        }
    }

}
