package com.yj.tel.service;

import com.yj.tel.mapper.MainMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MainService {

    private MainMapper mainMapper;

    public List<Map<String, Object>> getListsById(Map<String, Object> param) {
        if (param == null) {
            // trsp_id가 null인 경우, 전체 데이터를 조회하도록 처리
            return mainMapper.selectAllLists();
        } else {
            // trsp_id가 null이 아닌 경우, 조건에 맞는 데이터를 조회
            return mainMapper.selectListsById(param);
        }
    }

}
