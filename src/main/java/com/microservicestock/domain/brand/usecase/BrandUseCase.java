package com.microservicestock.domain.brand.usecase;

import com.microservicestock.domain.brand.model.Brand;
import com.microservicestock.domain.brand.port.persistence.IBrandPersistencePort;
import com.microservicestock.domain.brand.port.service.IBrandServicePort;

public class BrandUseCase  implements IBrandServicePort {
    private final IBrandPersistencePort brandPersistencePort;

    public BrandUseCase(IBrandPersistencePort brandPersistencePort) {
        this.brandPersistencePort = brandPersistencePort;
    }

   @Override
    public void saveBrand(Brand brand) {
        brandPersistencePort.saveBrand(brand);
    }
    @Override
    public boolean brandExistsByName(String name) {
        return brandPersistencePort.brandExistsByName(name);
    }
}
