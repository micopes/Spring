package com.example.demo.domain;

public class Member {

    private Long id; // 시스템이 정하는 id
    private String name; // 이름

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
