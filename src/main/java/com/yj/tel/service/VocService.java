package com.yj.tel.service;

import com.yj.tel.mapper.CompMapper;
import com.yj.tel.mapper.PenalityMapper;
import com.yj.tel.mapper.VocMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VocService {

    @Autowired
    private VocMapper vocMapper;
    @Autowired
    private PenalityMapper penalityMapper;
    @Autowired
    private CompMapper compMapper;

    /**
     * VOC 조회
     * */
    public List<Map<String, Object>> selectVoc(Map<String, Object> param) {
        return vocMapper.selectVoc(param);
    }

    /**
     * VOC 등록
     * */
    @Transactional
    public void insertVoc(Map<String, Object> param) {
        String compReqstYn =(String) param.get("comp_reqst_yn");

        try {
            // voc 등록
            vocMapper.insertVoc(param);

            // 마지막으로 삽입된 PK 값 가져오기 :: auto increase 썼기때문에 이렇게 가져왔지만, 인서트 채번을 따서 관리하면 이렇게 안해도 됨.
            Long generatedId = vocMapper.getLastInsertedId();
            param.put("voc_id", generatedId);

            // 배상_요청_여부가 Y인 경우 패널티 테이블 인서트
            if (compReqstYn != null && "Y".equals(compReqstYn)) {
                // 배상코드 정보 조회
                List<Map<String, Object>> resultList = compMapper.selectCompCode(param);

                if (resultList != null && !resultList.isEmpty()) {
                    Map<String, Object> map = resultList.get(0);

                    String compSe = (String) map.get("comp_se"); // if 분기용 구분 M, P

                    if (compSe != null && "M".equals(compSe)) { // M: 고정된 금액보상
                        param.put("penalityAmt", map.get("comp_amt"));
                    } else if (compSe != null && "P".equals(compSe)) { // P: 물품가액에 퍼센트 보상

                        // 배상코드 테이블의 배상률 부분 percent로 변경
                        BigDecimal compRatBigDecimal = (BigDecimal) map.get("comp_rat");
                        // BigDecimal 값을 double로 변환
                        double compRat = compRatBigDecimal.doubleValue() / 100.0;

                        // param에서 받아온 물품금액 * 배상률 = 패널티 금액 == 배상금액
                        int atcAmt = (int) param.get("atc_amt");
                        double penalityAmt = atcAmt * compRat;

                        // 패널티 금액 컬럼에 계산된 배상금액을 넣음.
                        param.put("penality_amt", penalityAmt);
                    }
                    // 패널티 테이블 인서트
                    penalityMapper.insertPenality(param);
                } else {
                    throw new RuntimeException("선택한 comp_id에 대한 정보가 없습니다.");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("VOC 등록 중 오류 발생", e);
        }
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
