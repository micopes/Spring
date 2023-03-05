package com.example.webproject.dto;

import com.example.webproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor // 생성자 대체
@ToString // toString() 대체
public class ArticleForm {

    private String title;
    private String content;



    public Article toEntity() {
        return new Article(null, title, content);
    }
}
