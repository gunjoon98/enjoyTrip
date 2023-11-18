package com.ssafy.enjoyTrip.model.service;

import com.ssafy.enjoyTrip.model.dto.Attraction;
import com.ssafy.enjoyTrip.model.dto.Keyword;
import com.ssafy.enjoyTrip.model.mapper.AttractionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AttractionService {

    private final AttractionMapper attractionMapper;
    //후에 전역 변수로 설정 필요
    private final int sizePerPage = 12;

    public List<Keyword> getKeywordList() {
        return attractionMapper.getKeywordList();
    }

    public List<Map<String, Object>> getcityList() {
        return attractionMapper.getcityList();
    }

    public List<Attraction> getAttractionListByKeyword(Map<String, Object> map) {
        List<Integer> keywordCodes = (List)map.get("keywordCodes");
        LocalDate dateTime = LocalDateTime.now().toLocalDate();

        for(int code : keywordCodes) {
            Map<String, Object> params = new HashMap<>();
            params.put("keywordCode", code);
            params.put("searchDate", dateTime);
            System.out.println("테스트 " + attractionMapper.getKeywordCount(params));
            if(attractionMapper.getKeywordCount(params) == null) {
                attractionMapper.registerKeywordCount(code);
            }
            attractionMapper.updateKeywordCount(params);
        }
        return attractionMapper.getAttractionListByKeyword(map);
    }

    public Attraction getAttraction(int attractionId) {
        return attractionMapper.getAttraction(attractionId);
    }

    public List<Attraction> getAttractionMapList(Map<String, Object> map) {
        Map<String, Object> params = new HashMap<>();
        params.put("start", (int)map.get("page") * sizePerPage);
        params.put("sizePerPage", sizePerPage);
        params.put("type", map.get("type"));
        params.put("cityCode", map.get("cityCode"));
        params.put("title", map.get("title"));
        params.put("exceptIdList", map.get("exceptIdList"));
        return attractionMapper.getAttractionMapList(params);
    }

    public List<Attraction> getAttractionMapListByUser(Map<String, Object> map) {
        Map<String, Object> params = new HashMap<>();
        params.put("start", (int)map.get("page") * sizePerPage);
        params.put("sizePerPage", sizePerPage);
        params.put("type", map.get("type"));
        params.put("cityCode", map.get("cityCode"));
        params.put("title", map.get("title"));
        params.put("userId", map.get("userId"));
        params.put("exceptIdList", map.get("exceptIdList"));
        return attractionMapper.getAttractionMapListByUser(params);
    }

    public List<Attraction> getInterestList(String userId) {
        return attractionMapper.getInterestList(userId);
    }

    public void registerInterest(Map<String, Object> map) {
        if(attractionMapper.getInterest(map) == null) attractionMapper.registerInterest(map);
    }

    public void deleteInterest(Map<String, Object> map) {
        attractionMapper.deleteInterest(map);
    }
}
