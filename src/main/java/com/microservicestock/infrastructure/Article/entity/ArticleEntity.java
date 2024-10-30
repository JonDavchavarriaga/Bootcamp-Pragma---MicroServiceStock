package com.microservicestock.infrastructure.Article.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "articles")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int quantity;
    private double price;

    @Column(name = "category_id") //
    private Long categoryId;

    @Column(name = "brand_id") //
    private Long brandId;



}
