package com.microservicestock.BrandTest.BrandInfrastrucrureTest;

import com.microservicestock.infrastructure.brand.adapter.persistence.IBrandRepository;
import com.microservicestock.infrastructure.brand.entity.BrandEntity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoryRepositoryTest {
    @Autowired
    private IBrandRepository brandRepository;
    @Autowired
    private LocalContainerEntityManagerFactoryBean entityManagerFactory;
    @Autowired
    private EntityManager entityManager;

    @Test
    @DisplayName("Test save brand in database with success")
    void testSaveBrandInDatabaseWithSuccess() {
        BrandEntity brandEntity = new BrandEntity(null,"Nike", "Sportswear");
        brandRepository.save(brandEntity);

        Optional<BrandEntity> retrievedBrand = brandRepository.findById(brandEntity.getId());
        assert retrievedBrand.isPresent();
        assertEquals("Nike", retrievedBrand.get().getName());
    }
    @Test
    @DisplayName("Test Exists by name")
    void testExistsByName() {
        BrandEntity brandEntity = new BrandEntity(null, "Nike", "Sportswear");
        brandRepository.save(brandEntity);
        entityManager.flush();
        boolean exists = brandRepository.existsByName("Nike");
        assertTrue(exists);
    }
    @Test
    @DisplayName("should Return Brand When Exists By Id")
    void shouldReturnBrandWhenExistsById() {
        BrandEntity brandEntity = new BrandEntity(null, "Nike", "Sportswear");
        entityManager.persist(brandEntity);

        Optional<BrandEntity> retrievedBrand = brandRepository.findById(brandEntity.getId());
        assert retrievedBrand.isPresent();
        assertEquals("Nike", retrievedBrand.get().getName());
    }
}
