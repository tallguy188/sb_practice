package com.ll.sb202311.domain.article.article.repository;

import com.ll.sb202311.domain.article.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

    public Article findLastArticle();
    public List<Article> findAll();



}
