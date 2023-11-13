package com.ssafy.enjoyTrip.model.service;

import com.ssafy.enjoyTrip.model.dto.Attraction;
import com.ssafy.enjoyTrip.model.dto.Keyword;
import com.ssafy.enjoyTrip.model.mapper.AttracionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AttractionService {
    private final AttracionMapper attracionMapper;

    public List<Keyword> getKeywordList() {
        return attracionMapper.getKeywordList();
    }

    public List<Map<String, Object>> getSidoList() {
        return attracionMapper.getSidoList();
    }

    public List<Attraction> getAttractionList(Map<String, Object> map) {
        return attracionMapper.getAttractionList(map);
    }


}
