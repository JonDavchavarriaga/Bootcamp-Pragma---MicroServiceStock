package com.microservicestock.infrastructure.Article.adapter.persistence;

import com.microservicestock.infrastructure.Article.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArticleRepository extends JpaRepository<ArticleEntity, Long> {
}
