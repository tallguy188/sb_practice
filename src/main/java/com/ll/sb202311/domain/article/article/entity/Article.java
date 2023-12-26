package com.ll.sb202311.domain.article.article.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Article {
    private long id;
    private String title;
    private String body;
}
