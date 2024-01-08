package com.ll.sb202311.domain.article.article.controller;

import com.ll.sb202311.domain.article.article.entity.Article;
import com.ll.sb202311.domain.article.article.service.ArticleService;
import com.ll.sb202311.global.rq.Rq;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@ToString
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
    String showDetail(Model model, @PathVariable long id) {
        Article article = articleService.findById(id).get();
        model.addAttribute("article", article);
        return "article/detail";
    }

    @GetMapping("/article/delete/{id}")
    String delete(@PathVariable long id) {
        articleService.delete(id);

        return "redirect:/article/list" ;
    }
    @Getter
    @Setter
    public static class ModifyForm {
        @NotBlank
        private String title;
        @NotBlank
        private String body;
    }

    @PostMapping("/article/modify/{id}")
    String write(@PathVariable long id, @Valid ModifyForm modifyForm) {
        articleService.modify(id, modifyForm.title, modifyForm.body);

        return "redirect:/article/list";
    }
}

