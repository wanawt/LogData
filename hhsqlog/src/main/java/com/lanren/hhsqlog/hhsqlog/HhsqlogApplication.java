package com.lanren.hhsqlog.hhsqlog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;

@SpringBootApplication
public class HhsqlogApplication {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        SpringApplication.run(HhsqlogApplication.class, args);
    }
}
