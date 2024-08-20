package com.microservicestock.infrastructure.infrastructureCategory.adapter.persistence;

import com.microservicestock.infrastructure.infrastructureCategory.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iCategoryRepository  extends JpaRepository<CategoryEntity, Long> {
    default boolean existsByName(String name) {
        return false;
    }
}
