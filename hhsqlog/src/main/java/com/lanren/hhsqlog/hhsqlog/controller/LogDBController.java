package com.lanren.hhsqlog.hhsqlog.controller;

import com.alibaba.fastjson.JSON;
import com.lanren.hhsqlog.hhsqlog.util.JsonUtil;
import com.lanren.hhsqlog.hhsqlog.util.LogDBManager;
import com.lanren.hhsqlog.hhsqlog.util.ProcessLogFiles;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

@RestController
@CrossOrigin
public class LogDBController {

    @RequestMapping("/insertLogData")
    public String insertLogData() throws SQLException, ClassNotFoundException {
        ArrayList list = ProcessLogFiles.parseJsonFile();
        try {
            LogDBManager.insertTableFromLog(list);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "{\"msg\":\"更新成功\"}";
    }

    @RequestMapping("/queryLogData")
    public String queryLogData() throws SQLException, ClassNotFoundException {
        ArrayList list = LogDBManager.queryLogData();
        return JSON.toJSONString(list);
    }
}
