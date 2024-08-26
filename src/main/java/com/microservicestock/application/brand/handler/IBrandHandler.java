package com.microservicestock.application.brand.handler;

import com.microservicestock.application.brand.dto.BrandDto;

public interface IBrandHandler {
    void saveBrand(BrandDto brandDto);
}
