package com.yj.tel.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CompMapper {

    /**
     * tp_Compensation :: 배상정보 테이블 CRUD
     * */
    public List<Map<String, Object>> selectComp(Map<String, Object> param);
    public void insertComp(Map<String, Object> param);
    public void updateComp(Map<String, Object> param);
    public void deleteComp(Map<String, Object> param);

    /**
     * tp_CompensationCode :: 배상정보코드 테이블 CRUD
     * */
    public List<Map<String, Object>> selectCompCode(Map<String, Object> param);
    public void insertCompCode(Map<String, Object> param);
    public void updateCompCode(Map<String, Object> param);
    public void deleteCompCode(Map<String, Object> param);
    public List<Map<String, Object>> selectCompCodeUseAt(Map<String, Object> param);


}
