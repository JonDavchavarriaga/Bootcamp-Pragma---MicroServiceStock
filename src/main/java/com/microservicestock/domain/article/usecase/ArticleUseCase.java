package com.microservicestock.domain.article.usecase;

import com.microservicestock.domain.article.model.Article;
import com.microservicestock.domain.article.port.persistence.IArticlePersistencePort;
import com.microservicestock.domain.article.port.service.IArticleServicePort;

public class ArticleUseCase implements IArticleServicePort {
    public final IArticlePersistencePort articlePersistencePort;

    public ArticleUseCase(IArticlePersistencePort articlePersistencePort) {
        this.articlePersistencePort = articlePersistencePort;
    }
    @Override
    public void saveArticle(Article article) {
        articlePersistencePort.saveArticle(article);
    }
}
