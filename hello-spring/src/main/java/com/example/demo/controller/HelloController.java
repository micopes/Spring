package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    // GetMapping : get 방식으로 url에 매칭된 것 .../hello
    @GetMapping("hello")
    public String hello(Model model) {
        // key : data, value : hello!!
        model.addAttribute("data", "hello!!");
        // 리턴값 "hello"는 hello.html의 파일 이름 "hello"를 말하는 것 . 이곳으로 가서 렌더링.
        // 컨트롤러에서 리턴 값으로 문자를 반환하면 viewResolver가 화면을 찾아서 처리한다.
        return "hello";
    }

    // @RequestParam이 default가 값이 있어야 하는 것이므로 인자로 "?....." 을 넣어줘야 한다. ex) localhost:8080/hello-mvc?name=spring!!!
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
}
