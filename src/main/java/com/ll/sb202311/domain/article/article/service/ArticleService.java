package com.ll.sb202311.domain.article.article.service;


import com.ll.sb202311.domain.article.article.entity.Article;
import com.ll.sb202311.domain.article.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final List<Article> articles = new ArrayList<>();


    public Article write(String title, String body) {
        Article article  = new Article(title, body);
        articleRepository.save(article);
        return article;
    }

    public Article findLastArticle() {
        return articleRepository.findLastArticle();
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Optional<Article> findById(long id) {
        return articles.stream()
                .filter(article -> article.getId() == id)
                .findFirst();
    }


}
