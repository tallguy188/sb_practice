package com.ll.sb202311.domain.article.article.repository;

import com.ll.sb202311.domain.article.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Long> {

    public Article findLastArticle();
    public List<Article> findAll();


}
