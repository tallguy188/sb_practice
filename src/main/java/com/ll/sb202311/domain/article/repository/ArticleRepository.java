package com.ll.sb202311.domain.article.repository;

import com.ll.sb202311.domain.article.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
