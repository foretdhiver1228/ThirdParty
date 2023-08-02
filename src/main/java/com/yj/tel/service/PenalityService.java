package com.yj.tel.service;

import com.yj.tel.mapper.CompMapper;
import com.yj.tel.mapper.PenalityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class PenalityService {

    @Autowired
    private PenalityMapper penalityMapper;

    @Autowired
    private CompMapper compMapper;

    /**
     * 패널티 조회
     * */
    public List<Map<String, Object>> selectPenality(Map<String, Object> param) {

        return penalityMapper.selectPenality(param);
    }

    /**
     * 패널티 등록
     * */
    public void insertPenality(Map<String, Object> param) {

        penalityMapper.insertPenality(param);
    }

    /**
     * 패널티 수정
     * */
    @Transactional
    public void updatePenality(Map<String, Object> param) {
        String chkYn = (String) param.get("driver_chk_yn");
        // 기사확인 Push 알림 전송후 에 대한 처리
        try {
            if ("Y".equals(chkYn)) { // 기사확인 Y
                penalityMapper.updatePenality(param);  // 1. 기사_확인_여부 Y 업데이트

                // 이의제기 여부 N 일시 베상 완료 처리.
                param.put("dispute_raised_yn", "N");
                // 이의제기 여부 Y 일시 패널티 다시 생성.

                compMapper.insertComp(param);         // 2. 배상정보 insert
            } else {
                penalityMapper.updatePenality(param);
            }
        } catch (Exception e) {
            throw new RuntimeException("패널티 기사확인 수정 중 오류 발생", e);
        }
    }

    /**
     * 패널티 삭제
     * */
    public void deletePenality(Map<String, Object> param) {
        // voc_id 사용중인 데이터 개수가 0일 때만 삭제
        if (penalityMapper.checkPenalityUseAt(param).isEmpty()) {

            penalityMapper.deletePenality(param);
        } else {
            throw new RuntimeException("사용중인 Penality_id는 삭제 불가능합니다.");
        }

    }
}
