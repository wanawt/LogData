package com.lanren.hhsqlog.hhsqlog.controller;

import com.lanren.hhsqlog.hhsqlog.util.LogDBManager;
import com.lanren.hhsqlog.hhsqlog.util.ProcessLogFiles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@CrossOrigin
public class LogDataController {

    @RequestMapping("/logDataManage")
    public String logDataManage () {
        return "logDataManage";
    }

}
