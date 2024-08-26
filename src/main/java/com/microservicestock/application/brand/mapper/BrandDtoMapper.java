package com.microservicestock.application.brand.mapper;


import com.microservicestock.application.brand.dto.BrandDto;
import com.microservicestock.domain.brand.model.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandDtoMapper {
    Brand toDomain(BrandDto brandDto);
    BrandDto toDto(Brand brand);
}
