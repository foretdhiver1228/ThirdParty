package com.yj.tel.service;

import com.yj.tel.mapper.CompMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CompService {

    @Autowired
    private CompMapper compMapper;

    /**
     * 배상정보 조회
     * */
    public List<Map<String, Object>> selectComp(Map<String, Object> param) {

        return compMapper.selectComp(param);
    }

    /**
     * 배상정보 등록
     * */
    public void insertComp(Map<String, Object> param) {

        compMapper.insertComp(param);
    }

    /**
     * 배상정보 수정
     * */
    public void updateComp(Map<String, Object> param) {

        compMapper.updateComp(param);
    }

    /**
     * 배상정보 삭제
     * */
    public void deleteComp(Map<String, Object> param) {

        compMapper.deleteComp(param);
    }

    /**
     * 배상정보코드 조회
     * */
    public List<Map<String, Object>> selectCompCode(Map<String, Object> param) {

        return compMapper.selectComp(param);
    }

    /**
     * 배상정보코드 등록
     * */
    public void insertCompCode(Map<String, Object> param) {

        compMapper.insertComp(param);
    }

    /**
     * 배상정보코드 수정
     * */
    public void updateCompCode(Map<String, Object> param) {

        compMapper.updateComp(param);
    }

    /**
     * 배상정보코드 삭제
     * */
    public void deleteCompCode(Map<String, Object> param) {

        compMapper.deleteComp(param);
    }
}
