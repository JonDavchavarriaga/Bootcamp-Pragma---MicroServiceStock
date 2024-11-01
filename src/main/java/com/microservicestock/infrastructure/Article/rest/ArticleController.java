package com.microservicestock.infrastructure.Article.rest;

import com.microservicestock.application.Article.dto.ArticleDto;
import com.microservicestock.application.Article.handler.IArticleHandler;
import com.microservicestock.domain.article.model.PaginatedResult;
import jakarta.annotation.security.PermitAll;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Article")
public class ArticleController {
    private final IArticleHandler articleHandler;

    public ArticleController(IArticleHandler articleHandler) {
        this.articleHandler = articleHandler;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')") // Solo administradores pueden crear artículos
    public ResponseEntity<Void> saveCategory(@RequestBody ArticleDto articleDto) {
        articleHandler.saveArticle(articleDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    @PermitAll // Ruta pública
    public PaginatedResult<ArticleDto> getArticles(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy,
            @RequestParam boolean ascending) {
        return articleHandler.getAllArticles(page, size, sortBy, ascending);
    }
}




