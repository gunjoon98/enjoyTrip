package com.ssafy.enjoyTrip.model.mapper;

import com.ssafy.enjoyTrip.model.dto.Attraction;
import com.ssafy.enjoyTrip.model.dto.Keyword;

import java.util.List;
import java.util.Map;

public interface AttractionMapper {
    List<Keyword> getKeywordList();
    List<Map<String, Object>> getcityList();
    List<Attraction> getAttractionListByKeyword(Map<String, Object> map);
    Attraction getAttraction(int attractionId);
    List<Attraction> getAttractionMapList(Map<String, Object> map);
    List<Attraction> getAttractionMapListByUser(Map<String, Object> map);
    List<Attraction> getInterestList(String userId);
    Integer getKeywordCount(Map<String, Object> map);
    String getInterest(Map<String, Object> map);
    int registerKeywordCount(int keywordCode);
    int updateKeywordCount(Map<String, Object> map);
    int registerInterest(Map<String, Object> map);
    int deleteInterest(Map<String, Object> map);
}

