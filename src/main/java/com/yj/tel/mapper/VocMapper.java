package com.yj.tel.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface VocMapper {

    public List<Map<String, Object>> selectVoc(Map<String, Object> param);
    public void insertVoc(Map<String, Object> param);
    public void updateVoc(Map<String, Object> param);
    public void deleteVoc(Map<String, Object> param);
}
