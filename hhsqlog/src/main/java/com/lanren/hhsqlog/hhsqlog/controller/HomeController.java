package com.lanren.hhsqlog.hhsqlog.controller;

import com.lanren.hhsqlog.hhsqlog.util.LogDBManager;
import com.lanren.hhsqlog.hhsqlog.util.ProcessLogFiles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class HomeController {
    @RequestMapping("/index")
    public String index() throws SQLException, ClassNotFoundException {
//        ArrayList list = ProcessLogFiles.parseJsonFile();
//        LogDBManager.insertTableFromLog(list);
        return "hehehe";
    }
}
