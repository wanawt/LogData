package com.lanren.hhsqlog.hhsqlog;
import com.lanren.hhsqlog.hhsqlog.controller.LogDBController;
import com.lanren.hhsqlog.hhsqlog.util.LogDBManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;
import java.text.ParseException;

@SpringBootApplication
public class HhsqlogApplication {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
        SpringApplication.run(HhsqlogApplication.class, args);
    }
}
