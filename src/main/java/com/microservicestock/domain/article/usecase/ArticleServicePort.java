package com.microservicestock.domain.article.usecase;

import com.microservicestock.domain.article.model.Article;
import com.microservicestock.domain.article.model.PaginatedResult;
import com.microservicestock.domain.article.port.persistence.IArticlePersistencePort;
import com.microservicestock.domain.article.port.service.IArticleServicePort;

import java.util.List;

public class ArticleServicePort implements IArticleServicePort {

    private final IArticlePersistencePort articlePersistencePort;



    public ArticleServicePort(IArticlePersistencePort articlePersistencePort) {
        this.articlePersistencePort = articlePersistencePort;
    }

    @Override
    public void SaveArticle(Article article) {
        articlePersistencePort.SaveArticle(article);
    }


    @Override
    public PaginatedResult<Article> getAllArticles(int page, int size, String sortBy, boolean ascending){
        return  articlePersistencePort.findAllSortedAndPaginated(page, size, sortBy, ascending);
    }
}
