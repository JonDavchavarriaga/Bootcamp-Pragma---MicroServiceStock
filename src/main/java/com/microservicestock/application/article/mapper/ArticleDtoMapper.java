package com.microservicestock.application.article.mapper;

import com.microservicestock.application.article.dto.ArticleDto;
import com.microservicestock.domain.article.model.Article;

public interface ArticleDtoMapper {
    Article toDomain(ArticleDto articleDto);
    ArticleDto toDto(Article article);
}
