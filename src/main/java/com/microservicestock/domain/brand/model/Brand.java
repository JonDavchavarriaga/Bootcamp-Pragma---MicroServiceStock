package com.microservicestock.domain.brand.model;

import com.microservicestock.domain.brand.model.brandConstants.brandConstants;

public class Brand {
    Long id;
    String name;
    String description;
    private static final int NAME_MAX_LENGTH = brandConstants.NAME_MAX_LEGTH;
    private static final int DESCRIPTION_MAX_LENGTH = brandConstants.DESCRIPTION_MAX_LENGTH;

    public Brand() {
    }
    public Brand(Long id, String name, String description) {
        validateName(name);
        validateDescription(description);
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public Brand(String name, String description) {
        validateName(name);
        validateDescription(description);
        this.name = name;
        this.description = description;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public void setName(String name) {
        validateName(name);
        this.name = name;
    }
    public void setDescription(String description) {
        validateDescription(description);
        this.description = description;
    }

    public void validateName(String name) {
        if (name == null || name.trim().isBlank()) {
            throw new IllegalArgumentException(brandConstants.BRAND_NAME_REQUIRED);
        }
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(brandConstants.INVALID_BRAND_NAME);
        }
    }
    public void validateDescription(String description) {
        if (description == null || description.trim().isBlank()) {
            throw new IllegalArgumentException(brandConstants.BRAND_DESCRIPTION_REQUIRED);
        }
        if (description.length() > DESCRIPTION_MAX_LENGTH) {
            throw new IllegalArgumentException(brandConstants.INVALID_BRAND_DESCRIPTION);
        }
    }
}
