package com.yj.tel.service;

import com.yj.tel.mapper.TrspMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TrspService {

    @Autowired
    private TrspMapper trspMapper;

    /**
     * 운송사 조회
     * */
    public List<Map<String, Object>> selectTrsp(Map<String, Object> param) {

        return trspMapper.selectTrsp(param);
    }

    /**
     * 운송사 등록
     * */
    public void insertTrsp(Map<String, Object> param) {

        trspMapper.insertTrsp(param);
    }

    /**
     * 운송사 수정
     * */
    public void updateTrsp(Map<String, Object> param) {

        trspMapper.updateTrsp(param);
    }
}
