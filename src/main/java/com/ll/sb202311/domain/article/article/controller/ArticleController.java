package com.ll.sb202311.domain.article.article.controller;

import com.ll.sb202311.domain.article.article.entity.Article;
import com.ll.sb202311.domain.article.article.service.ArticleService;
import com.ll.sb202311.global.rq.Rq;
import com.ll.sb202311.global.rsData.RsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    private final Rq rq;

    @GetMapping("/article/write")
    String showWrite() {
        return "article/write";
    }

    @PostMapping("/article/write")
    @ResponseBody
    RsData doWrite(
            String title,
            String body
    ) {
        if (title == null || title.trim().length() == 0) {
            return new RsData<>(
                    "F-1",
                    "제목을 입력해주세요."
            );
        }

        if (body == null || body.trim().length() == 0) {
            return new RsData<>(
                    "F-2",
                    "내용을 입력해주세요."
            );
        }

        Article article =  articleService.write(title,body);

        RsData<Article> rs = new RsData<>(  // article버전 rsData
                "S-1",
                "%d번 게시물이 작성되었습니다.".formatted(article.getId()),
                article
        );

        return rs;
    }

    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Article getLastArticle() {
        return articleService.findLastArticle();
    }

    @GetMapping("/article/getArticles")
    @ResponseBody
    List<Article> getArticles() {
        return articleService.findAll();
    }
}

