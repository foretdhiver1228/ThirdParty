package com.yj.tel.controller;

import com.yj.tel.service.TrspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TrspController {

    @Autowired
    private TrspService trspService;

    /**
     * 운송사 조회
     * */
    @GetMapping("/trsp")
    public List<Map<String, Object>> getTrsp(@RequestParam Map<String, Object> param) {
        return trspService.selectTrsp(param);
    }

    /**
     * 운송사 등록
     * */
    @PostMapping("/trsp")
    public ResponseEntity<String> postTrsp(@RequestBody Map<String, Object> param) {
        trspService.insertTrsp(param); //
        return new ResponseEntity<>("운송사 등록 성공", HttpStatus.CREATED);
    }

    /**
     * 운송사 수정
     * */
    @PutMapping("/trsp")
    public ResponseEntity<String> putTrsp(@RequestBody Map<String, Object> param) {
        trspService.updateTrsp(param); //
        return new ResponseEntity<>("운송사 수정 성공", HttpStatus.CREATED);
    }

    /**
     * 운송사 삭제
     * */
    @DeleteMapping("/trsp")
    public ResponseEntity<String> deleteTrsp(@RequestBody Map<String, Object> param) {
        trspService.deleteTrsp(param); //
        return new ResponseEntity<>("운송사 삭제 성공", HttpStatus.CREATED);
    }
}