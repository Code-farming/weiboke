package com.lhb.weiboke.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("message")
    public String message(){
        return "message";
    }

    @GetMapping("about")
    public String about(){
        return "about";
    }

    @GetMapping("note")
    public String newNote(){
        return "note_new";
    }
}
