package com.example.webproject.repository;

import com.example.webproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article, Long> { // 관리 대상 entity와 대표값의 타입을 인자로 넣어준다.

    @Override
    ArrayList<Article> findAll();
}
