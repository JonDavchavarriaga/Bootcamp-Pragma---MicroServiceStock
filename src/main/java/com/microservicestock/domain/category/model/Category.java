package com.microservicestock.domain.category.model;
import com.microservicestock.domain.category.model.categoryConstants.categoryConstant;

public class Category {
    private Long id;
    private String name;
    private String description;

    private static final int NAME_MAX_LENGTH = categoryConstant.NAME_MAX_LEGTH;
    private static final int DESCRIPTION_MAX_LENGTH = categoryConstant.DESCRIPTION_MAX_LENGTH;


    public Category() {
    }

    public Category(Long id, String name, String description) {
        validateName(name);
        validateDescription(description);
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public Category(String name, String description) {
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
            throw new IllegalArgumentException(categoryConstant.CATEGORY_NAME_REQUIRED);
        }
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(categoryConstant.INVALID_CATEGORY_NAME);
        }
    }

    public void validateDescription(String description) {
        if (description == null || description.trim().isBlank()) {
            throw new IllegalArgumentException(categoryConstant.CATEGORY_DESCRIPTION_REQUIRED);
        }
        if (description.length() >DESCRIPTION_MAX_LENGTH) {
            throw new IllegalArgumentException(categoryConstant.INVALID_CATEGORY_DESCRIPTION);
        }
    }

}
