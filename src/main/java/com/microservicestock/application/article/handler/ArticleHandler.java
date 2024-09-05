package com.microservicestock.application.article.handler;

import com.microservicestock.application.article.dto.ArticleDto;
import com.microservicestock.application.article.mapper.ArticleDtoMapper;
import com.microservicestock.domain.article.port.service.IArticleServicePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleHandler   {
    //private final IArticleServicePort articleServicePort;
    //private final ArticleDtoMapper articleDtoMapper;

    //@Override
    //public void saveArticle(ArticleDto articleDto) {
    //    articleServicePort.saveArticle(articleDtoMapper.toDomain(articleDto));
    //}
}
