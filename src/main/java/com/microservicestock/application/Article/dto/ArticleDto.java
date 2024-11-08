package com.microservicestock.application.Article.dto;

import com.microservicestock.domain.brand.model.Brand;
import com.microservicestock.domain.category.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    private Long id;
    private String name;
    private String description;
    private int quantity;
    private double price;
    private String image;
    private Long categoryId;
    private Long brandId;
}
