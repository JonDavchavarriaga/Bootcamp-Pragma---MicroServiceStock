package com.microservicestock.infrastructure.configuration;

import com.microservicestock.domain.category.port.persistence.ICategoryPersistencePort;
import com.microservicestock.domain.category.port.service.ICategoryServicePort;
import com.microservicestock.domain.category.usecase.CategoryUseCase;
import com.microservicestock.infrastructure.category.adapter.entity.CategoryAdapterEntity;
import com.microservicestock.infrastructure.category.adapter.mapper.CategoryMapperEntity;
import com.microservicestock.infrastructure.category.adapter.persistence.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ICategoryRepository categoryRepository;
    private final CategoryMapperEntity categoryEntityMapper;

    @Bean
    public ICategoryPersistencePort categoryPersistencePort() {
        return new CategoryAdapterEntity(categoryRepository, categoryEntityMapper);
    }
    @Bean
    public ICategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }

}
