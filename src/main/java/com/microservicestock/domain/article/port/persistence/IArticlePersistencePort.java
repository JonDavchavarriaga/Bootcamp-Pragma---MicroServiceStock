package com.microservicestock.domain.article.port.persistence;

import com.microservicestock.domain.article.model.Article;

public interface IArticlePersistencePort {
    void saveArticle(Article article);
}
