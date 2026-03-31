package com.example.apprds.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/time")
@Log4j2
@RequiredArgsConstructor
public class TimeController {

    private final DataSource dataSource;

    @RequestMapping("/now")
    public Map<String, String> getNow() {

        String now = "";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("SELECT NOW()");
                ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                now = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Map.of("now", now);
    }

}
