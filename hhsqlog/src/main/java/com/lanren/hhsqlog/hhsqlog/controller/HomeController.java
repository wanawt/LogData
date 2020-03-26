package com.lanren.hhsqlog.hhsqlog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@CrossOrigin
public class HomeController {

    @RequestMapping("/index")
    public String index() throws SQLException, ClassNotFoundException {
        return "index";
    }

}
