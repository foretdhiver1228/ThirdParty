package com.yj.tel.controller;

import com.yj.tel.service.CompService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CompController {

    @Autowired
    private CompService compService;

    /**
     * 배상정보 조회
     * */
    @GetMapping("/comp")
    public List<Map<String, Object>> getComp(@RequestParam Map<String, Object> param) {
        return compService.selectComp(param);
    }

    /**
     * 배상정보 등록
     * */
    @PostMapping("/comp")
    public ResponseEntity<String> postComp(@RequestBody Map<String, Object> param) {
        compService.insertComp(param); //
        return new ResponseEntity<>("배상정보 등록 성공", HttpStatus.CREATED);
    }

    /**
     * 배상정보 수정
     * */
    @PutMapping("/comp")
    public ResponseEntity<String> putComp(@RequestBody Map<String, Object> param) {
        compService.updateComp(param); //
        return new ResponseEntity<>("배상정보 수정 성공", HttpStatus.CREATED);
    }

    /**
     * 배상정보 삭제
     * */
    @DeleteMapping("/comp")
    public ResponseEntity<String> deleteComp(@RequestBody Map<String, Object> param) {
        compService.deleteComp(param); //
        return new ResponseEntity<>("배상정보 삭제 성공", HttpStatus.CREATED);
    }
}