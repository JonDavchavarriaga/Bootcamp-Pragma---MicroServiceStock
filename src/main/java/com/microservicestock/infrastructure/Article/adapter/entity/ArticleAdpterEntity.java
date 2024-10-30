package com.microservicestock.infrastructure.Article.adapter.entity;

import com.microservicestock.domain.article.model.Article;
import com.microservicestock.domain.article.model.PaginatedResult;
import com.microservicestock.domain.article.port.persistence.IArticlePersistencePort;
import com.microservicestock.infrastructure.Article.adapter.mapper.ArticleMapperEntity;
import com.microservicestock.infrastructure.Article.adapter.persistence.IArticleRepository;
import com.microservicestock.infrastructure.Article.entity.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;

import java.util.List;
import java.util.stream.Collectors;


public class ArticleAdpterEntity implements IArticlePersistencePort {
      IArticleRepository articleRepository;
      ArticleMapperEntity articleMapperEntity;

    public ArticleAdpterEntity(IArticleRepository articleRepository,  ArticleMapperEntity articleMapperEntity) {
        this.articleRepository = articleRepository;
        this.articleMapperEntity = articleMapperEntity;
    }

    @Override
    public void SaveArticle(Article article) {
        articleRepository.save(articleMapperEntity.toEntity(article));
    }

    @Override
    public PaginatedResult<Article> findAllSortedAndPaginated(int page, int size, String sortBy, boolean ascending){
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        PageRequest pageRequest = PageRequest.of(page,size,sort);
        Page<ArticleEntity> articlesPage = articleRepository.findAll(pageRequest);
        List<Article>Article = articlesPage.stream().map(articleMapperEntity::toDomain).collect(Collectors.toList());
        return new PaginatedResult<>(Article,articlesPage.getNumber(),articlesPage.getSize(),articlesPage.getTotalElements(),articlesPage.getTotalPages(), articlesPage.isFirst(),articlesPage.isLast()) ;
    }
}
