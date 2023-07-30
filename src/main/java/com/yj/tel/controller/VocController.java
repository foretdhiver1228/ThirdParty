package com.yj.tel.controller;

import com.yj.tel.service.VocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class VocController {

    @Autowired
    private VocService vocService;

    /**
     * VOC 조회
     * */
    @GetMapping("/voc")
    public List<Map<String, Object>> getVoc(@RequestParam Map<String, Object> param) {
        return vocService.selectVoc(param);
    }

    /**
     * VOC 등록
     * */
    @PostMapping("/voc")
    public ResponseEntity<String> postVoc(@RequestBody Map<String, Object> param) {
        vocService.insertVoc(param); //
        return new ResponseEntity<>("VOC 등록 성공", HttpStatus.CREATED);
    }

    /**
     * VOC 수정
     * */
    @PutMapping("/voc")
    public ResponseEntity<String> putVoc(@RequestBody Map<String, Object> param) {
        vocService.updateVoc(param); //
        return new ResponseEntity<>("VOC 수정 성공", HttpStatus.CREATED);
    }

    /**
     * VOC 삭제
     * */
    @DeleteMapping("/voc")
    public ResponseEntity<String> deleteVoc(@RequestBody Map<String, Object> param) {
        vocService.deleteVoc(param); //
        return new ResponseEntity<>("VOC 삭제 성공", HttpStatus.CREATED);
    }
}