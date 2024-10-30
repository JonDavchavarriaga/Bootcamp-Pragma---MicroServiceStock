package com.microservicestock.infrastructure.Article.adapter.mapper;


import com.microservicestock.application.Article.dto.ArticleDto;
import com.microservicestock.domain.article.model.Article;
import com.microservicestock.infrastructure.Article.entity.ArticleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleMapperEntity {
    ArticleEntity toEntity(Article article);
    Article toDomain(ArticleEntity articleEntity);
}
