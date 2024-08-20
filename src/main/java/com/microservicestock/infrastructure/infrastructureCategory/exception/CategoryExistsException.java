package com.microservicestock.infrastructure.infrastructureCategory.exception;

public class CategoryExistsException extends RuntimeException {
    public CategoryExistsException(String message) {
        super(message);
    }
}
