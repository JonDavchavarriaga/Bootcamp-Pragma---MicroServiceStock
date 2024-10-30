package com.microservicestock.application.Article.mapper;

import com.microservicestock.application.Article.dto.ArticleDto;
import com.microservicestock.domain.article.model.Article;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleDtoMapper {
    Article toDomain(ArticleDto articleDto);
    ArticleDto toDto(Article article);
}
