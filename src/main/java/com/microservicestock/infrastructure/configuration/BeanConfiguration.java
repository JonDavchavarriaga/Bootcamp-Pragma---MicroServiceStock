package com.microservicestock.infrastructure.configuration;

import com.microservicestock.domain.Category.CategoryPort.CategoryPortPersistence.iCategoryPersistencePort;
import com.microservicestock.domain.Category.CategoryPort.CategoryPortService.iCategoryServicePort;
import com.microservicestock.domain.Category.CategoryUseCases.CategoryUseCase;
import com.microservicestock.infrastructure.infrastructureCategory.adapter.adapterCategoryEntity.CategoryAdapterEntity;
import com.microservicestock.infrastructure.infrastructureCategory.adapter.adapterMapper.CategoryMapperEntity;
import com.microservicestock.infrastructure.infrastructureCategory.adapter.persistence.iCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final iCategoryRepository categoryRepository;
    private final CategoryMapperEntity categoryEntityMapper;

    @Bean
    public iCategoryPersistencePort categoryPersistencePort() {
        return new CategoryAdapterEntity(categoryRepository, categoryEntityMapper);
    }
    @Bean
    public iCategoryServicePort CategoryRepository() {
        return new CategoryUseCase(categoryPersistencePort());
    }

}
