package com.yj.tel.controller;

import com.yj.tel.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CustController {

    @Autowired
    private CustService custService;

    /**
     * 고객사 조회
     * */
    @GetMapping("/cust")
    public List<Map<String, Object>> getCust(@RequestParam Map<String, Object> param) {
        return custService.selectCust(param);
    }

    /**
     * 고객사 등록
     * */
    @PostMapping("/cust")
    public ResponseEntity<String> postCust(@RequestBody Map<String, Object> param) {
        custService.insertCust(param); //
        return new ResponseEntity<>("고객사 등록 성공", HttpStatus.CREATED);
    }

    /**
     * 고객사 수정
     * */
    @PutMapping("/cust")
    public ResponseEntity<String> putCust(@RequestBody Map<String, Object> param) {
        custService.updateCust(param); //
        return new ResponseEntity<>("고객사 수정 성공", HttpStatus.CREATED);
    }
}