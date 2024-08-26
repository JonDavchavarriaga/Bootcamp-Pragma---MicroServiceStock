package com.microservicestock.infrastructure.brand.exeption;

public class BrandExistsException extends RuntimeException {
    public BrandExistsException(String message) {
        super(message);
    }
}
