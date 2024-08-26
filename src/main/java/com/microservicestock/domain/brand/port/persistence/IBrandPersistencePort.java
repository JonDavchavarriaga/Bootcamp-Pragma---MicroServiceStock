package com.microservicestock.domain.brand.port.persistence;

import com.microservicestock.domain.brand.model.Brand;
import java.util.List;

public interface IBrandPersistencePort {
    void saveBrand(Brand brand);

    boolean brandExistsByName(String name);

    List<Brand> getAllBrands();
}
