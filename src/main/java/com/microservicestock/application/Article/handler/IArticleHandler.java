package com.microservicestock.application.Article.handler;

import com.microservicestock.application.Article.dto.ArticleDto;
import com.microservicestock.application.category.dto.CategoryDto;
import com.microservicestock.domain.article.model.PaginatedResult;

public interface IArticleHandler {
    void saveArticle(ArticleDto articleDto);
   PaginatedResult<ArticleDto> getAllArticles(int page, int pageSize, String sortBy, Boolean ascending);
}
