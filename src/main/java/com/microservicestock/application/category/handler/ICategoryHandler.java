package com.microservicestock.application.category.handler;

import com.microservicestock.application.category.dto.CategoryDto;
import java.util.List;
public interface ICategoryHandler {
    void saveCategory(CategoryDto categoryDto);

    List<CategoryDto> getCategoriesSortedAndPaged(int page, int size, boolean ascending);
}
