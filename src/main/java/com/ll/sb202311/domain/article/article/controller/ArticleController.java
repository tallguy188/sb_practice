package com.ll.sb202311.domain.article.article.controller;

import com.ll.sb202311.domain.article.article.entity.Article;
import com.ll.sb202311.domain.article.article.service.ArticleService;
import com.ll.sb202311.global.rq.Rq;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    private final Rq rq;

    @GetMapping("/article/write")
    String showWrite() {
        return "article/write";
    }


    @Getter
    @Setter
    public static class WriteForm {
        @NotBlank
        private String title;
        @NotBlank
        private String body;

    }

    @PostMapping("/article/write")

    String doWrite(@Valid WriteForm writeForm
    ) {

        Article article = articleService.write(writeForm.title, writeForm.body);
        return "redirect:/article/list";
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

    @GetMapping("/article/list")
    String showList(Model model) {
        List<Article> articles = articleService.findAll();

        model.addAttribute("articles", articles);

        return "article/list";
    }

    @GetMapping("/article/detail/{id}")
    @ResponseBody
    String showDetail(@PathVariable long id) {
        Optional<Article> opArticle = articleService.findById(id);
        Article article = opArticle.get(); // 값이 없으면 get()때문에 프로그램이 뻗음

        return "article/detail";
    }
}

