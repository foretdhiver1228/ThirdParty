package com.yj.tel.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustMapper {

    /**
     * ls_Customer :: 고객사 테이블 CRUD
     * */
    public List<Map<String, Object>> selectCust(Map<String, Object> param);
    public void insertCust(Map<String, Object> param);
    public void updateCust(Map<String, Object> param);
    public void deleteCust(Map<String, Object> param);
}
