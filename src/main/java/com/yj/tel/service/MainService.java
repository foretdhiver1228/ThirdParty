package com.yj.tel.service;

import com.yj.tel.mapper.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MainService {

    @Autowired
    private MainMapper mainMapper;

    /**
     * VOC 조회
     * */
    public List<Map<String, Object>> selectVoc(Map<String, Object> param) {
        return mainMapper.selectVoc(param);
    }

    /**
     * VOC 등록
     * */
    public void insertVoc(Map<String, Object> param) {
        mainMapper.insertVoc(param);
    }

    /**
     * VOC 수정
     * */
    public void updateVoc(Map<String, Object> param) {
        mainMapper.updateVoc(param);
    }

    /**
     * VOC 삭제
     * */
    public void deleteVoc(Map<String, Object> param) {
        mainMapper.deleteVoc(param);
    }

}
