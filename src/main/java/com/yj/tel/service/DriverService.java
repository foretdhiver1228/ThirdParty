package com.yj.tel.service;

import com.yj.tel.mapper.DriverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DriverService {

    @Autowired
    private DriverMapper driverMapper;

    /**
     * 배송기사 조회
     * */
    public List<Map<String, Object>> selectDriver(Map<String, Object> param) {

        return driverMapper.selectDriver(param);
    }

    /**
     * 배송기사 등록
     * */
    public void insertDriver(Map<String, Object> param) {

        driverMapper.insertDriver(param);
    }

    /**
     * 배송기사 수정
     * */
    public void updateDriver(Map<String, Object> param) {

        driverMapper.updateDriver(param);
    }

    /**
     * 배송기사의 패널티 내역 조회
     * */
    public List<Map<String, Object>> selectDriverPenality(Map<String, Object> param) {

        return driverMapper.selectDriverPenality(param);
    }
}
