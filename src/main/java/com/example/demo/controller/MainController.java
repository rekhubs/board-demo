package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    @RequestMapping(value = "/**/{[path:[^\\.]*}")
    public String index(final HttpServletRequest request) {
        return "forward:/index.html";
    }
}
