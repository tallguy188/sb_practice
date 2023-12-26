package com.ll.sb202311.domain.article.article.service;


import com.ll.sb202311.domain.article.article.entity.Article;
import com.ll.sb202311.domain.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final  List<Article> articles = new ArrayList<>();


    public Article write(String title, String body) {
        Article article  = new Article(articles.size() + 1, title, body);
        articles.add(article);
        return article;
    }

    public Article findLastArticle() {
        return articles.get(articles.size()-1);
    }

    public List<Article> findAll() {
        return articles;
    }
}
