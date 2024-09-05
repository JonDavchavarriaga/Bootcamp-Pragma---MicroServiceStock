package com.microservicestock.CategoryTest.CategoryInfrastructureTest;

import com.microservicestock.infrastructure.category.adapter.persistence.ICategoryRepository;
import com.microservicestock.infrastructure.category.entity.CategoryEntity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoryRepositoryTest {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private LocalContainerEntityManagerFactoryBean entityManagerFactory;

    @Autowired
    private EntityManager entityManager;


    @Test
    @DisplayName("Test save category in database with success")
    void testSaveCategoryInDatabaseWithSuccess() {
        CategoryEntity categoryEntity = new CategoryEntity(null, "Category Test", "Category Test Description");
        categoryRepository.save(categoryEntity);

        Optional<CategoryEntity> retrievedCategory = categoryRepository.findById(categoryEntity.getId());
        assert retrievedCategory.isPresent();
        assertEquals("Category Test", retrievedCategory.get().getName());
    }
    @Test
    @DisplayName("should Return Category When Exists By Id")
    void shouldReturnCategoryWhenExistsById() {
        CategoryEntity categoryEntity = new CategoryEntity(null, "Category Test", "Category Test Description");
        entityManager.persist(categoryEntity);

        Optional<CategoryEntity> retrievedCategory = categoryRepository.findById(categoryEntity.getId());
        assert retrievedCategory.isPresent();
        assertEquals("Category Test", retrievedCategory.get().getName());

    }
}
