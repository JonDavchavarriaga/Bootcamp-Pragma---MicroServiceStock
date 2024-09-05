package com.microservicestock.domain.brand.port.service;

import com.microservicestock.domain.brand.model.Brand;
import java.util.List;

public interface IBrandServicePort {
    void saveBrand(Brand brand);
    boolean brandExistsByName(String name);
    List<Brand> getAllBrands();
    List<Brand> getBrandsSortedAndPaged(int page, int size, boolean ascending);
    Brand getBrandById(Long id);
}
