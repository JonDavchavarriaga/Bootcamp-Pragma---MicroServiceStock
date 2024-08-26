package com.microservicestock.domain.brand.port.service;

import com.microservicestock.domain.brand.model.Brand;

public interface IBrandServicePort {
    void saveBrand(Brand brand);
    boolean brandExistsByName(String name);
}
