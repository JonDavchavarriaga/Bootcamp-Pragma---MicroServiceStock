package com.microservicestock.application.brand.handler;

import com.microservicestock.application.brand.dto.BrandDto;
import com.microservicestock.domain.brand.model.Brand;

import java.util.List;

public interface IBrandHandler {
    void saveBrand(BrandDto brandDto);
    List<BrandDto> getBrandsSortedAndPaged(int page, int size, boolean ascending);
    BrandDto getBrandById(Long id);
}
