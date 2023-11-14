package com.ssafy.enjoyTrip.model.service;

import com.ssafy.enjoyTrip.model.dto.Attraction;
import com.ssafy.enjoyTrip.model.dto.Keyword;
import com.ssafy.enjoyTrip.model.mapper.AttractionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AttractionService {

    private final AttractionMapper attractionMapper;

    public List<Keyword> getKeywordList() {
        return attractionMapper.getKeywordList();
    }

    public List<Map<String, Object>> getcityList() {
        return attractionMapper.getcityList();
    }

    public List<Attraction> getAttracionList(Map<String, Object> map) {
        return attractionMapper.getAttractionList(map);
    }

    public Attraction getAttraction(int attractionId) {
        return attractionMapper.getAttraction(attractionId);
    }

    public void registerInterest(Map<String, Object> map) {
        attractionMapper.registerInterest(map);
    }

    public void deleteInterest(int attractionId) {
        attractionMapper.deleteInterest(attractionId);
    }
}
