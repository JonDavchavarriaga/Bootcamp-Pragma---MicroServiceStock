package com.microservicestock.infrastructure.configuration;

import com.microservicestock.domain.brand.port.persistence.IBrandPersistencePort;
import com.microservicestock.domain.brand.port.service.IBrandServicePort;
import com.microservicestock.domain.brand.usecase.BrandUseCase;
import com.microservicestock.infrastructure.brand.adapter.entity.BrandAdapterEntity;
import com.microservicestock.infrastructure.brand.adapter.mapper.BrandMapperEntity;
import com.microservicestock.infrastructure.brand.adapter.persistence.IBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanBrandConfiguration {
    private final IBrandRepository brandRepository;
    private final BrandMapperEntity brandEntityMapper;

    @Bean
    public IBrandPersistencePort brandPersistencePort() {
        return new BrandAdapterEntity(brandRepository, brandEntityMapper);
    }
    @Bean
    public IBrandServicePort brandServicePort() {
        return new BrandUseCase(brandPersistencePort());
    }
}
