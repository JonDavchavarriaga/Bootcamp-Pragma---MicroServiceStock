package com.microservicestock.domain.article.port.service;

import com.microservicestock.domain.article.model.Article;
import com.microservicestock.domain.article.model.PaginatedResult;

import java.util.List;

public interface IArticleServicePort {
    void  SaveArticle(Article article);
    PaginatedResult<Article> getAllArticles(int page, int size, String sortBy, boolean ascending);
}
