package com.microservicestock.infrastructure.category.exception;

public class CategoryExistsException extends RuntimeException {
    public CategoryExistsException(String message) {
        super(message);
    }
}
