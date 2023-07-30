package com.yj.tel.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TrspMapper {

    /**
     * ls_Transporter :: 운송사 테이블 CRUD
     * */
    public List<Map<String, Object>> selectTrsp(Map<String, Object> param);
    public void insertTrsp(Map<String, Object> param);
    public void updateTrsp(Map<String, Object> param);
    public void deleteTrsp(Map<String, Object> param);
}
