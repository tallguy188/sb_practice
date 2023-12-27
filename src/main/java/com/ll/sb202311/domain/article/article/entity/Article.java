package com.ll.sb202311.domain.article.article.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Article {
    private Long id;
    private String title;
    private String body;

    public Article(String title, String body){
        this.title = title;
        this.body = body;
    }


}
