package com.example.webproject.controller;

import com.example.webproject.dto.ArticleForm;
import com.example.webproject.entity.Article;
import com.example.webproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j // 로깅을 위한 annotation
public class ArticleController {

    @Autowired // 스프링부트가 미리 생성해놓은 객체를 가져다가 자동 연결 (ex) 자동차 핸들만 알면 운전 가능)
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        log.info(form.toString());

        // 0. 입력된 값을 Dto로 받음.

        // 1. Dto -> Entity
        Article article = form.toEntity();
        log.info(article.toString());

        // 2. Repository에게 Entity를 DB안에 저장하도록 한다.
        Article saved = articleRepository.save(article);
        log.info(saved.toString());

        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) { // url 요청을 parameter로 받아오기 위해 @PathVariable 사용
        log.info("id = " + id);

        // 1: id로 데이터를 가져옴
        // Optional<Article> articleEntity = articleRepository.findById(id); // 해당 값이 없을 수도 있기 때문에 Optional을 이용 - Java 8
        Article articleEntity = articleRepository.findById(id).orElse(null); // java 8에 안익숙하다면 다음과 같이 이용 가능

        // 2: 가져온 데이터를 모델에 등록
        model.addAttribute("article", articleEntity);

        // 3: 보여줄 페이지를 설정
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {
        // 1. 모든 Article을 가져온다.
        List<Article> articleEntityList = articleRepository.findAll();

        // 2. 가져온 Article 묶음을 View로 전달
        model.addAttribute("articleList", articleEntityList);

        // 3. View 페이지를 설정
        return "articles/index";
    }
}
