package com.microservicestock.CategoryTest.CategoryModelTest;

import com.microservicestock.domain.category.model.Category;
import com.microservicestock.domain.category.model.categoryConstants.categoryConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CategoryModelTest {


    @Test
    @DisplayName("Create Category Model Test with correct name and description")
    void CreateCategoryModelTest_withCorrectNameAndDescription() {
        String categoryName = "Toys";
        String categoryDescription = "Children's playthings";
        Category categoryModel = new Category(categoryName, categoryDescription);

        assertEquals(categoryName, categoryModel.getName());
        assertEquals(categoryDescription, categoryModel.getDescription());
    }

    @Test
    @DisplayName("Create Category Model Test with Null Name")
    void CreateCategoryModelTest_withNullName() {
        String categoryDescription = "Children's playthings";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Category(null, categoryDescription)
        );
        assertEquals(categoryConstant.CATEGORY_NAME_REQUIRED, exception.getMessage());
    }
    @Test
    @DisplayName("Create Category Model Test with Empty Name")
    void CreateCategoryModelTest_withEmptyName() {
        String categoryDescription = "Children's playthings";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Category("", categoryDescription)
        );
        assertEquals(categoryConstant.CATEGORY_NAME_REQUIRED, exception.getMessage());
    }
    @Test
    @DisplayName("Create Category Model Test with Null Description")
    void CreateCategoryModelTest_withNullDescription() {
        String categoryName = "Toys";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Category(categoryName, null)
        );
        assertEquals(categoryConstant.CATEGORY_DESCRIPTION_REQUIRED, exception.getMessage());
    }
    @Test
    @DisplayName("Create Category Model Test with Empty Description")
    void CreateCategoryModelTest_withEmptyDescription() {
        String categoryName = "Toys";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Category(categoryName, "")
        );
        assertEquals(categoryConstant.CATEGORY_DESCRIPTION_REQUIRED, exception.getMessage());
    }
    @Test
    @DisplayName("Create Category Model Test with Name Exceeding Max Length")
    void CreateCategoryModelTest_withNameExceedingMaxLength() {
        String categoryName = "AA".repeat(categoryConstant.NAME_MAX_LEGTH);
        String categoryDescription = "Children's playthings";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Category(categoryName, categoryDescription)
        );
        assertEquals(categoryConstant.INVALID_CATEGORY_NAME, exception.getMessage());
    }
    @Test
    @DisplayName("Create Category Model Test with Description Exceeding Max Length")
    void CreateCategoryModelTest_withDescriptionExceedingMaxLength() {
        String categoryName = "Toys";
        String categoryDescription = "AA".repeat(categoryConstant.DESCRIPTION_MAX_LENGTH);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Category(categoryName, categoryDescription)
        );
        assertEquals(categoryConstant.INVALID_CATEGORY_DESCRIPTION, exception.getMessage());
    }


}
