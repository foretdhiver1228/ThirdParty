package com.yj.tel.service;

import com.yj.tel.mapper.VocMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class VocService {

    @Autowired
    private VocMapper vocMapper;

    /**
     * VOC 조회
     * */
    public List<Map<String, Object>> selectVoc(Map<String, Object> param) {
        return vocMapper.selectVoc(param);
    }

    /**
     * VOC 등록
     * */
    public void insertVoc(Map<String, Object> param) {

        vocMapper.insertVoc(param);
    }

    /**
     * VOC 수정
     * */
    public void updateVoc(Map<String, Object> param) {
        vocMapper.updateVoc(param);
    }

    /**
     * VOC 삭제
     * */
    public void deleteVoc(Map<String, Object> param) {
        // voc_id 사용중인 데이터 개수가 0일 때만 삭제
        if (vocMapper.selectVocUseAt(param).isEmpty()) {
            vocMapper.deleteVoc(param);
        } else {
            throw new RuntimeException("사용중인 vocId는 삭제 불가능합니다.");
        }
    }

}
