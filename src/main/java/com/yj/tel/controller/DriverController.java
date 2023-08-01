package com.yj.tel.controller;

import com.yj.tel.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class DriverController {

    @Autowired
    private DriverService driverService;

    /**
     * 배송기사 조회
     * */
    @GetMapping("/driver")
    public List<Map<String, Object>> getDriver(@RequestParam Map<String, Object> param) {
        return driverService.selectDriver(param);
    }

    /**
     * 배송기사 등록
     * */
    @PostMapping("/driver")
    public ResponseEntity<String> postDriver(@RequestBody Map<String, Object> param) {
        driverService.insertDriver(param); //
        return new ResponseEntity<>("배송기사 등록 성공", HttpStatus.CREATED);
    }

    /**
     * 배송기사 수정
     * */
    @PutMapping("/driver")
    public ResponseEntity<String> putDriver(@RequestBody Map<String, Object> param) {
        driverService.updateDriver(param); //
        return new ResponseEntity<>("배송기사 수정 성공", HttpStatus.CREATED);
    }
}