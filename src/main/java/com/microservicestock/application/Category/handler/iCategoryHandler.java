package com.microservicestock.application.Category.handler;

import com.microservicestock.application.Category.dto.CategoryDto;

public interface iCategoryHandler {
    void saveCategory(CategoryDto categoryDto);
}
