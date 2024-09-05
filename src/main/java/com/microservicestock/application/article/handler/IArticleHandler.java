package com.microservicestock.application.article.handler;

import com.microservicestock.application.article.dto.ArticleDto;

public interface IArticleHandler {
    void saveArticle(ArticleDto articleDto);
}
