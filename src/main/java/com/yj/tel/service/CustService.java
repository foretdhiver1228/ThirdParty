package com.yj.tel.service;

import com.yj.tel.mapper.CustMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustService {

    @Autowired
    private CustMapper custMapper;

    /**
     * 고객사 조회
     * */
    public List<Map<String, Object>> selectCust(Map<String, Object> param) {

        return custMapper.selectCust(param);
    }

    /**
     * 고객사 등록
     * */
    public void insertCust(Map<String, Object> param) {

        custMapper.insertCust(param);
    }

    /**
     * 고객사 수정
     * */
    public void updateCust(Map<String, Object> param) {

        custMapper.updateCust(param);
    }

    /**
     * 고객사 삭제
     * */
    public void deleteCust(Map<String, Object> param) {

        custMapper.deleteCust(param);
    }
}
