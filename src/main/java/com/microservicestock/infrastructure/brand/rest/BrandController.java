package com.microservicestock.infrastructure.brand.rest;

import com.microservicestock.application.brand.dto.BrandDto;
import com.microservicestock.application.brand.handler.IBrandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController {
    private final IBrandHandler brandHandler;

    @PostMapping
    public ResponseEntity<Void> saveBrand(@RequestBody BrandDto brandDto) {
        brandHandler.saveBrand(brandDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
    public ResponseEntity<List<BrandDto>> getBrands(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "true") boolean ascending) {

        List<BrandDto> brands = brandHandler.getBrandsSortedAndPaged(page, size, ascending);
        return ResponseEntity.ok(brands);
    }

}
