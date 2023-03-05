package com.example.webproject.controller;

import com.example.webproject.dto.ArticleForm;
import com.example.webproject.entity.Article;
import com.example.webproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired // 스프링부트가 미리 생성해놓은 객체를 가져다가 자동 연결 (ex) 자동차 핸들만 알면 운전 가능)
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        System.out.println(form.toString());

        // 0. 입력된 값을 Dto로 받음.

        // 1. Dto -> Entity
        Article article = form.toEntity();
        System.out.println(article.toString());

        // 2. Repository에게 Entity를 DB안에 저장하도록 한다.
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());

        return "";
    }
}