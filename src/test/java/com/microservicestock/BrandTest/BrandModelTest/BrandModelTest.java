package com.microservicestock.BrandTest.BrandModelTest;

import com.microservicestock.domain.brand.model.Brand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.microservicestock.domain.brand.model.brandConstants.brandConstants;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BrandModelTest {

    @Test
    @DisplayName("Create Brand Model Test with correct name and description")
    void CreateBrandModelTest_withCorrectNameAndDescription() {
        String brandName ="Nike";
        String brandDescription = "Sportswear";
        Brand brandModel = new Brand(brandName, brandDescription);
        assertEquals(brandName, brandModel.getName());
        assertEquals(brandDescription, brandModel.getDescription());
    }
    @Test
    @DisplayName("Create Brand Model Test with Null Name")
    void CreateBrandModelTest_withNullName() {
        String brandDescription = "Sportswear";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Brand(null, brandDescription)
        );
        assertEquals(brandConstants.BRAND_NAME_REQUIRED, exception.getMessage());
    }
    @Test
    @DisplayName("Create Brand Model Test with Empty Name")
    void CreateBrandModelTest_withEmptyName() {
        String brandDescription = "Sportswear";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Brand("", brandDescription)
        );
        assertEquals(brandConstants.BRAND_NAME_REQUIRED, exception.getMessage());
    }
    @Test
    @DisplayName("Create Brand Model Test with Null Description")
    void CreateBrandModelTest_withNullDescription() {
        String brandName = "Nike";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Brand(brandName, null)
        );
        assertEquals(brandConstants.BRAND_DESCRIPTION_REQUIRED, exception.getMessage());
    }
    @Test
    @DisplayName("Create Brand Model Test with Empty Description")
    void CreateBrandModelTest_withEmptyDescription() {
        String brandName = "Nike";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Brand(brandName, "")
        );
        assertEquals(brandConstants.BRAND_DESCRIPTION_REQUIRED, exception.getMessage());
    }
    @Test
    @DisplayName("Create Brand Model Test with Null Name exeded 50 characters")
    void CreateBrandModelTest_withNullNameExeded50Characters(){
        String brandName = "AA".repeat(brandConstants.NAME_MAX_LEGTH);
        String brandDescription = "Sportswear";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Brand(brandName, brandDescription)
        );
        assertEquals(brandConstants.INVALID_BRAND_NAME, exception.getMessage());
    }
    @Test
    @DisplayName("Create Brand Model Test with Null Description exeded 120 characters")
    void CreateBrandModelTest_withNullDescriptionExeded120Characters(){
        String brandName = "Nike";
        String brandDescription = "AA".repeat(brandConstants.DESCRIPTION_MAX_LENGTH);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Brand(brandName, brandDescription)
        );
        assertEquals(brandConstants.INVALID_BRAND_DESCRIPTION, exception.getMessage());
    }
}
