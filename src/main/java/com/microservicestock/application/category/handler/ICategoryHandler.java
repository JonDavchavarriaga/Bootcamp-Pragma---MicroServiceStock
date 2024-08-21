package com.microservicestock.application.category.handler;

import com.microservicestock.application.category.dto.CategoryDto;

public interface ICategoryHandler {
    void saveCategory(CategoryDto categoryDto);
}
