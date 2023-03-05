package com.example.webproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {
        model.addAttribute("username", "Minjin");

        return "greetings";
    }

    @GetMapping("/bye")
    public String seeYouLater(Model model) {
        model.addAttribute("nickname", "Gildong");

        return "goodbye";
    }
}
