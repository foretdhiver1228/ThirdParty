package com.yj.tel.service;

import com.yj.tel.mapper.PenalityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PenalityService {

    @Autowired
    private PenalityMapper penalityMapper;

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
    public void updatePenality(Map<String, Object> param) {

        penalityMapper.updatePenality(param);
    }

    /**
     * 패널티 삭제
     * */
    public void deletePenality(Map<String, Object> param) {

        penalityMapper.deletePenality(param);
    }
}
