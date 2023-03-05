package com.example.webproject.entity;

import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // DB가 해당 객체를 인식 가능하도록
@AllArgsConstructor
@ToString
public class Article {

    @Id // 대표값을 지정
    @GeneratedValue // 1, 2, 3 ... 자동 생성
    private Long id;

    @Column
    private String title;

    @Column
    private String content;
}
