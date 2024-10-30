package com.microservicestock.application.Article.handler;

import com.microservicestock.application.Article.dto.ArticleDto;
import com.microservicestock.application.Article.mapper.ArticleDtoMapper;
import com.microservicestock.domain.article.model.Article;
import com.microservicestock.domain.article.model.PaginatedResult;
import com.microservicestock.domain.article.port.service.IArticleServicePort;
import java.util.List;
import java.util.stream.Collectors;


public class ArticleHandler  implements IArticleHandler {
    private ArticleDtoMapper articleDtoMapper;
    private IArticleServicePort articleServicePort;

    public ArticleHandler(ArticleDtoMapper articleDtoMapper, IArticleServicePort articleServicePort) {
        this.articleDtoMapper = articleDtoMapper;
        this.articleServicePort = articleServicePort;
    }

    @Override
    public void saveArticle(ArticleDto articleDto) {
        Article article = articleDtoMapper.toDomain(articleDto);
        articleServicePort.SaveArticle(article);

    }

    @Override
    public PaginatedResult<ArticleDto> getAllArticles(int page, int pageSize, String sortBy, Boolean ascending){
        PaginatedResult<Article> result = articleServicePort.getAllArticles(page, pageSize, sortBy, ascending);
        List<ArticleDto> categoryDTOs = result.getContent().stream().map(articleDtoMapper::toDto).collect(Collectors.toList());
        return new PaginatedResult<>(categoryDTOs,
                result.getPageNumber(),
                result.getPageSize(),
                result.getTotalElements(),
                result.getTotalPages(),
                result.isFirst(),
                result.isLast());
    }
}

