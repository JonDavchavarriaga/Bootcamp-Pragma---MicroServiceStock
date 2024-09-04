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
     private List<Category> categories;
     private Brand brand;

     private static final int CATEGORY_MINIMUN = articleConstants.CATEGORY_MINIMUN;
        private static final int CATEGORY_MAXIMUN = articleConstants.CATEGORY_MAXIMUN;
     public Article() {
     }

     public Article(Long id, String name, String description, int quantity, double price, List<Category> categories, Brand brand) {
         validateCategories(categories);
         validateNoRepeatedCategories(categories);
         this.id = id;
         this.name = name;
         this.description = description;
         this.quantity = quantity;
         this.price = price;
         this.categories = categories;
         this.brand = brand;
     }
     public Article(String name, String description, int quantity, double price, List<Category> categories, Brand brand) {
         validateCategories(categories);
         validateNoRepeatedCategories(categories);
         this.name = name;
         this.description = description;
         this.quantity = quantity;
         this.price = price;
         this.categories = categories;
         this.brand = brand;
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
        public int getQuantity() {
            return quantity;
        }
        public double getPrice() {
            return price;
        }
        public List<Category> getCategories() {
            return categories;
        }
        public Brand getBrand() {
            return brand;
        }
        public void setCategories(List<Category> categories) {
            validateCategories(categories);
            validateNoRepeatedCategories(categories);
            this.categories = categories;
        }
    public  void validateCategories(List<Category> categories){
        if(categories.size() < CATEGORY_MINIMUN){
            throw new IllegalArgumentException(articleConstants.ARTICLE_CATEGORYES_MINIMUN);
        }
        if(categories.size() > CATEGORY_MAXIMUN){
            throw new IllegalArgumentException(articleConstants.ARTICLE_CATEGORYES_MAXIMUN);
        }
    }

    public void validateNoRepeatedCategories(List<Category> categories){
        for(int i = 0; i < categories.size(); i++){
            for(int j = i + 1; j < categories.size(); j++){
                if(categories.get(i).getId().equals(categories.get(j).getId())){
                    throw new IllegalArgumentException(articleConstants.ARTICLE_CATEGORYES_REPEATED);
                }
            }
        }
    }



}
