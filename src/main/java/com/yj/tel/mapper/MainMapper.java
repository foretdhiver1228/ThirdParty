package com.yj.tel.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MainMapper {
    public List<Map<String, Object>> selectListsById(Map<String, Object> param);
    public List<Map<String, Object>> selectAllLists();

}
