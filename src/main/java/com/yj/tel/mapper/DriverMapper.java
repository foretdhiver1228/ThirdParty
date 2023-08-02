package com.yj.tel.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DriverMapper {

    /**
     * tp_Driver :: 운송사 테이블 CRUD
     * */
    public List<Map<String, Object>> selectDriver(Map<String, Object> param);
    public void insertDriver(Map<String, Object> param);
    public void updateDriver(Map<String, Object> param);
    public List<Map<String, Object>> selectDriverPenality(Map<String, Object> param);
}
