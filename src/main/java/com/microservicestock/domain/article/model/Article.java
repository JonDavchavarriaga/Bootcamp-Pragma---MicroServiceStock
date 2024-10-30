package com.microservicestock.domain.article.model;
import com.microservicestock.domain.article.model.articleConstants.articleConstants;
import com.microservicestock.domain.brand.model.Brand;
import com.microservicestock.domain.category.model.Category;

import java.util.List;

public class Article {
     private Long id;
     private String name;
     private String description;
     private int quantity;
     private double price;
     private Long categoryId;
     private Long brandId;

    public Article(Long id, String name, String description, int quantity, double price, Long categoryId, Long brandId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.categoryId = categoryId;
        this.brandId = brandId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
}
