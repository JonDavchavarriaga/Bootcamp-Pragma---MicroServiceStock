package com.microservicestock.application.brand.handler;

import com.microservicestock.application.brand.dto.BrandDto;
import com.microservicestock.application.brand.mapper.BrandDtoMapper;
import com.microservicestock.domain.brand.model.Brand;
import com.microservicestock.domain.brand.port.service.IBrandServicePort;
import com.microservicestock.domain.brand.model.brandConstants.brandConstants;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    @Override
    public List<BrandDto> getBrandsSortedAndPaged(int page, int size, boolean ascending) {
        List<Brand> brands = brandServicePort.getBrandsSortedAndPaged(page, size, ascending);
        return brands.stream()
                .map(brandDtoMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public BrandDto getBrandById(Long id) {
        try {
            Brand brand = brandServicePort.getBrandById(id);
            return brandDtoMapper.toDto(brand);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(brandConstants.BRAND_NOT_FOUND);
        }
    }
}
