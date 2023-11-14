package com.ssafy.enjoyTrip.model.mapper;

import com.ssafy.enjoyTrip.model.dto.Attraction;
import com.ssafy.enjoyTrip.model.dto.Keyword;

import java.util.List;
import java.util.Map;

public interface AttractionMapper {
    List<Keyword> getKeywordList();
    List<Map<String, Object>> getcityList();
    List<Attraction> getAttractionList(Map<String, Object> map);
    Attraction getAttraction(int attractionId);
    List<Attraction> getInterestList(int attractionId);
    int registerInterest(Map<String, Object> map);
    int deleteInterest(int attractionId);
}

