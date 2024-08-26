package com.microservicestock.domain.brand.usecase;

import com.microservicestock.domain.brand.model.Brand;
import com.microservicestock.domain.brand.port.persistence.IBrandPersistencePort;
import com.microservicestock.domain.brand.port.service.IBrandServicePort;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


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
    @Override
    public List<Brand> getAllBrands() {
        return brandPersistencePort.getAllBrands();
    }
    public List<Brand> getBrandsSortedAndPaged(int page, int size, boolean ascending) {
        List<Brand> brands = getAllBrands();

        if (ascending) {
            brands = brands.stream()
                    .sorted(Comparator.comparing(Brand::getName))
                    .collect(Collectors.toList());
        } else {
            brands = brands.stream()
                    .sorted(Comparator.comparing(Brand::getName).reversed())
                    .collect(Collectors.toList());
        }

        int start = Math.min(page * size, brands.size());
        int end = Math.min(start + size, brands.size());

        return brands.subList(start, end);
    }
}
