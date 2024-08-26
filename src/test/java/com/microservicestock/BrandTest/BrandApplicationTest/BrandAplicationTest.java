package com.microservicestock.BrandTest.BrandApplicationTest;

import com.microservicestock.application.brand.dto.BrandDto;
import com.microservicestock.application.brand.handler.BrandHandler;
import com.microservicestock.application.brand.mapper.BrandDtoMapper;
import com.microservicestock.domain.brand.model.Brand;
import com.microservicestock.domain.brand.port.service.IBrandServicePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class BrandAplicationTest {
     @Mock
     private IBrandServicePort brandServicePort;
     @Mock
     private BrandDtoMapper brandDtoMapper;
     @InjectMocks
     private BrandHandler brandHandler;
     @BeforeEach
        public void setUp() {MockitoAnnotations.openMocks(this);}

    @Test
    @DisplayName("Test save brand Should map dto to domain and save")
    void saveBrand_ShouldMapDtoToDomainAndCallService() {
        BrandDto brandDto = new BrandDto();
        Brand brand = new Brand("Nike", "Sportswear");
        when(brandDtoMapper.toDomain(brandDto)).thenReturn(brand);

        brandHandler.saveBrand(brandDto);

        verify(brandDtoMapper, times(1)).toDomain(brandDto);
        verify(brandServicePort, times(1)).saveBrand(brand);
    }
}
