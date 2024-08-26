package com.microservicestock.application.brand.handler;

import com.microservicestock.application.brand.dto.BrandDto;
import com.microservicestock.application.brand.mapper.BrandDtoMapper;
import com.microservicestock.domain.brand.model.Brand;
import com.microservicestock.domain.brand.port.service.IBrandServicePort;
import com.microservicestock.domain.brand.model.brandConstants.brandConstants;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class BrandHandler implements IBrandHandler {
    private final IBrandServicePort brandServicePort;
    private final BrandDtoMapper brandDtoMapper;

    @Override
    public void saveBrand(BrandDto brandDto) {
        Brand brand = brandDtoMapper.toDomain(brandDto);
        if(!brandServicePort.brandExistsByName(brand.getName())){
            brandServicePort.saveBrand(brand);
        }else{
            throw new IllegalArgumentException(brandConstants.BRAND_ALREADY_EXISTS);
        }
    }
}
