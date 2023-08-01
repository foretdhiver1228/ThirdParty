package com.yj.tel.controller;

import com.yj.tel.service.PenalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PenalityController {

    @Autowired
    private PenalityService penalityService;

    /**
     * 패널티 조회
     * */
    @GetMapping("/penality")
    public List<Map<String, Object>> getPenality(@RequestParam Map<String, Object> param) {
        return penalityService.selectPenality(param);
    }

    /**
     * 패널티 등록
     * */
    @PostMapping("/penality")
    public ResponseEntity<String> postCust(@RequestBody Map<String, Object> param) {
        penalityService.insertPenality(param); //
        return new ResponseEntity<>("패널티 등록 성공", HttpStatus.CREATED);
    }

    /**
     * 패널티 수정
     * */
    @PutMapping("/penality")
    public ResponseEntity<String> putCust(@RequestBody Map<String, Object> param) {
        penalityService.updatePenality(param); //
        return new ResponseEntity<>("패널티 수정 성공", HttpStatus.CREATED);
    }

    /**
     * 패널티 삭제
     * */
    @DeleteMapping("/penality")
    public ResponseEntity<String> deleteCust(@RequestBody Map<String, Object> param) {
        String penality_id = "";
        penality_id = param.get("penality_id").toString();

        try {
            penalityService.deletePenality(param);
            return ResponseEntity.ok("penality_id : " + penality_id + " 가 성공적으로 삭제되었습니다.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(e.getMessage());
        }
    }
}