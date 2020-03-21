package com.lanren.hhsqlog.hhsqlog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
