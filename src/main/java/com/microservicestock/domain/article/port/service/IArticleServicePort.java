package com.microservicestock.domain.article.port.service;

import com.microservicestock.domain.article.model.Article;

public interface IArticleServicePort {
    void saveArticle(Article article);
}
