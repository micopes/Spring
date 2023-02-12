package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-string")
    @ResponseBody // Body 부분에 리턴 값에 해당하는 내용을 그대로 넣어주겠다는 것. View 같은게 없음
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    // 객체(Hello)를 넘기면 JsonConverter
    // 문자를 넘기면 StringConverter
    // 두 경우 모두 - JSON 형태로 반환 (Default. XML로 반환할 수도 있긴 함)
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        // Getter & Setter. private를 getter/setter 메소드를 통해 가져올 수 있도록 함 - 프로퍼티 접근 방식.
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
