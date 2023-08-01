package com.yj.tel.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PenalityMapper {

    /**
     * ls_Penality :: 패널티 테이블 CRUD
     * */
    public List<Map<String, Object>> selectPenality(Map<String, Object> param);
    public void insertPenality(Map<String, Object> param);
    public void updatePenality(Map<String, Object> param);
    public void deletePenality(Map<String, Object> param);
    public List<Map<String, Object>> checkPenalityUseAt(Map<String, Object> param);
}
