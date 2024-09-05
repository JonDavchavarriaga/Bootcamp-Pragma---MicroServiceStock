package com.microservicestock.infrastructure.brand.adapter.entity;

import com.microservicestock.domain.brand.model.Brand;
import com.microservicestock.domain.brand.port.persistence.IBrandPersistencePort;
import com.microservicestock.infrastructure.brand.adapter.mapper.BrandMapperEntity;
import com.microservicestock.domain.brand.model.brandConstants.brandConstants;
import com.microservicestock.infrastructure.brand.adapter.persistence.IBrandRepository;
import com.microservicestock.infrastructure.brand.exeption.BrandExistsException;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class BrandAdapterEntity implements IBrandPersistencePort {
    private final IBrandRepository brandRepository;
    private final BrandMapperEntity brandMapperEntity;

    @Override
    public void saveBrand(Brand brand) {
        if (brandRepository.existsByName(brand.getName())) {
            throw new BrandExistsException(brandConstants.BRAND_ALREADY_EXISTS);
        }
        brandRepository.save(brandMapperEntity.toEntity(brand));
    }

    @Override
    public boolean brandExistsByName(String name) {
        return brandRepository.existsByName(name);
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll().stream()
                .map(brandMapperEntity::toDomain)
                .collect(Collectors.toList());
    }
    @Override
    public Brand getBrandById(Long id) {
        return brandRepository.findById(id)
                .map(brandMapperEntity::toDomain)
                .orElseThrow(() -> new IllegalArgumentException(brandConstants.BRAND_NOT_FOUND));
    }
}
