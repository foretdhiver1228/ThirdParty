package com.yj.tel.controller;

import com.yj.tel.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private MainService mainService;

    /**
     * VOC 조회
     * */
    @GetMapping("/voc")
    public List<Map<String, Object>> getVoc(@RequestParam Map<String, Object> param) {
        return mainService.selectVoc(param);
    }

    /**
     * VOC 등록
     * */
    @PostMapping("/voc")
    public ResponseEntity<String> postVoc(@RequestBody Map<String, Object> param) {
        mainService.insertVoc(param); //
        return new ResponseEntity<>("VOC 등록 성공", HttpStatus.CREATED);
    }

    /**
     * VOC 수정
     * */
    @PutMapping("/voc")
    public ResponseEntity<String> putVoc(@RequestBody Map<String, Object> param) {
        mainService.updateVoc(param); //
        return new ResponseEntity<>("VOC 수정 성공", HttpStatus.CREATED);
    }

    /**
     * VOC 삭제
     * */
    @DeleteMapping("/voc")
    public ResponseEntity<String> deleteVoc(@RequestBody Map<String, Object> param) {
        mainService.deleteVoc(param); //
        return new ResponseEntity<>("VOC 삭제 성공", HttpStatus.CREATED);
    }







    @PostMapping("/post-test")
    public ResponseEntity<List<Map<String, Object>>> getTestData(@RequestBody String id) {
        // logistics_system.ls_Customer 조회 쿼리 실행
        String sql = "select * from logistics_system.ls_Transporter";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);

        // 조회 결과 반환
        return ResponseEntity.ok(result);
    }

//    @PostMapping("/selectList")
//    public List<Map<String, Object>> getListsById(@RequestBody Map<String, Object> param) {
//        return mainService.getListsById(param);
//    }

}