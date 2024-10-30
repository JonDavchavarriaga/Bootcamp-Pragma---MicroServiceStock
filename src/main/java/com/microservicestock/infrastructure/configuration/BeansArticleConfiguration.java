package com.microservicestock.infrastructure.configuration;

import com.microservicestock.application.Article.handler.ArticleHandler;
import com.microservicestock.application.Article.handler.IArticleHandler;
import com.microservicestock.application.Article.mapper.ArticleDtoMapperImpl;
import com.microservicestock.domain.article.port.persistence.IArticlePersistencePort;
import com.microservicestock.domain.article.port.service.IArticleServicePort;
import com.microservicestock.domain.article.usecase.ArticleServicePort;
import com.microservicestock.infrastructure.Article.adapter.entity.ArticleAdpterEntity;
import com.microservicestock.infrastructure.Article.adapter.mapper.ArticleMapperEntityImpl;
import com.microservicestock.infrastructure.Article.adapter.persistence.IArticleRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansArticleConfiguration {

    @Bean
    public ArticleAdpterEntity ArticleAdpterEntity(IArticleRepository articleRepository) {
        return new ArticleAdpterEntity(articleRepository, new ArticleMapperEntityImpl());
    }


    @Bean
    public IArticleHandler articleHandler(IArticlePersistencePort articlePersistencePort) {
        return new ArticleHandler(new ArticleDtoMapperImpl(), new ArticleServicePort(articlePersistencePort));
    }
}
