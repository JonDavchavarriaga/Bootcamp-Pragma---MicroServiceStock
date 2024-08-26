package com.microservicestock.application.category.handler;

import com.microservicestock.application.category.dto.CategoryDto;
import com.microservicestock.application.category.mapper.CategoryDtoMapper;
import com.microservicestock.domain.category.model.Category;
import com.microservicestock.domain.category.model.categoryConstants.categoryConstant;
import com.microservicestock.domain.category.port.service.ICategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;


import java.util.List;
import java.util.stream.Collectors;

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
    @Override
    public List<CategoryDto> getCategoriesSortedAndPaged(int page, int size, boolean ascending) {
        List<Category> categories = categoryServicePort.getCategoriesSortedAndPaged(page, size, ascending);
        return categories.stream()
                .map(categoryDtoMapper::toDto)
                .collect(Collectors.toList());
    }

}
