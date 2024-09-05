package com.microservicestock.CategoryTest.AplicationTest;

import com.microservicestock.application.category.dto.CategoryDto;
import com.microservicestock.application.category.handler.CategoryHandler;
import com.microservicestock.application.category.mapper.CategoryDtoMapper;
import com.microservicestock.domain.category.model.Category;
import com.microservicestock.domain.category.port.service.ICategoryServicePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class CategoryAplicationTest {

    @Mock
    private ICategoryServicePort categoryServicePort;
    @Mock
    private CategoryDtoMapper categoryDtoMapper;
    @InjectMocks
    private CategoryHandler categoryHandler;

     @BeforeEach
    public void setUp() {
         MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test save category Should map dto to domain and save")
    void saveCategory_ShouldMapDtoToDomainAndCallService() {

        CategoryDto categoryDto = new CategoryDto();
        Category category = new Category("Toys", "Children's playthings");

        when(categoryDtoMapper.toDomain(categoryDto)).thenReturn(category);

        categoryHandler.saveCategory(categoryDto);

        verify(categoryDtoMapper, times(1)).toDomain(categoryDto);
        verify(categoryServicePort, times(1)).saveCategory(category);
    }

}
