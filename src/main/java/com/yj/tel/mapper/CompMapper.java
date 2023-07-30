package com.yj.tel.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CompMapper {

    public List<Map<String, Object>> selectComp(Map<String, Object> param);
    public void insertComp(Map<String, Object> param);
    public void updateComp(Map<String, Object> param);
    public void deleteComp(Map<String, Object> param);
}
