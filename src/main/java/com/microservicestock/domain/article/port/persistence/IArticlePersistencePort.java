package com.microservicestock.domain.article.port.persistence;

import com.microservicestock.domain.article.model.Article;
import com.microservicestock.domain.article.model.PaginatedResult;

import java.util.List;

public interface IArticlePersistencePort {
    void SaveArticle(Article article);
    PaginatedResult<Article> findAllSortedAndPaginated(int page, int size, String sortBy, boolean ascending);
}
