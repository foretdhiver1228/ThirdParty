package com.yj.tel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    @GetMapping("get-test")
//    public String getApi(@RequestParam("name") String name) {
//        return name;
//    }

    @PostMapping("post-test")
    public ResponseEntity<List<Map<String, Object>>> getTestData(@RequestBody String person) {
        // logistics_system.ls_Customer 조회 쿼리 실행
        String sql = "select * from logistics_system.ls_Transporter";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);

        // 조회 결과 반환
        return ResponseEntity.ok(result);
    }

//    @PostMapping("post-test")
//    public ResponseEntity<String> processData(@RequestBody String person) {
//        return ResponseEntity.ok(person);
//    }
}