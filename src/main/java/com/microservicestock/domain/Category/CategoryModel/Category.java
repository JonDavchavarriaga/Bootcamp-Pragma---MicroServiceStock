package com.microservicestock.domain.Category.CategoryModel;
import com.microservicestock.domain.Category.CategoryModel.CategoryConstants.CategoryConstant;

public class Category {
    private Long Id;
    private String name;
    private String description;

    private static final int NAME_MAX_LENGTH = CategoryConstant.NAME_MAX_LEGTH;
    private static final int DESCRIPTION_MAX_LENGTH = CategoryConstant.DESCRIPTION_MAX_LENGTH;


    public Category() {
    }

    public Category(Long Id, String name, String description) {
        ValidateName(name);
        ValidateDescription(description);
        this.Id = Id;
        this.name = name;
        this.description = description;
    }
    public Category(String name, String description) {
        ValidateName(name);
        ValidateDescription(description);
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        ValidateName(name);
        this.name = name;
    }

    public void setDescription(String description) {
        ValidateDescription(description);
        this.description = description;
    }

    public void ValidateName(String name) {
        if (name == null || name.trim().isBlank()) {
            throw new IllegalArgumentException(CategoryConstant.CATEGORY_NAME_REQUIRED);
        }
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CategoryConstant.INVALID_CATEGORY_NAME);
        }
    }

    public void ValidateDescription(String description) {
        if (description == null || description.trim().isBlank()) {
            throw new IllegalArgumentException(CategoryConstant.CATEGORY_DESCRIPTION_REQUIRED);
        }
        if (description.length() >DESCRIPTION_MAX_LENGTH) {
            throw new IllegalArgumentException(CategoryConstant.INVALID_CATEGORY_DESCRIPTION);
        }
    }

}
