package com.yj.tel.controller;

import com.yj.tel.service.VocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

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
        String vocId = "";
        vocId = param.get("voc_id").toString();

        try {
            vocService.deleteVoc(param); //
            return ResponseEntity.ok("vocId : " + vocId + " 가 성공적으로 삭제되었습니다.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(e.getMessage());
        }
    }
}