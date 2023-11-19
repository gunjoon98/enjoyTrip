package com.ssafy.enjoyTrip.model.user.service;

import com.ssafy.enjoyTrip.model.user.dto.*;
import com.ssafy.enjoyTrip.model.user.response.*;
import com.ssafy.enjoyTrip.model.user.mapper.AttractionMapper;
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

    public List<KeywordResponse> getKeywordList() {
        return attractionMapper.getKeywordList();
    }

    public List<CityResponse> getcityList() {
        return attractionMapper.getcityList();
    }

    public List<AttractionKeywordResponse> getAttractionListByKeyword(AttractionKeywordSearchDto attractionKeywordSearchDto) {
        List<Integer> keywordCodes = attractionKeywordSearchDto.getKeywordCodes();
        LocalDate dateTime = LocalDateTime.now().toLocalDate();

        if(keywordCodes != null) {
            for(int code : keywordCodes) {
                KeywordCountDto keywordCountDto = new KeywordCountDto(code, dateTime);
                if(attractionMapper.getKeywordCount(keywordCountDto) == null) {
                    attractionMapper.registerKeywordCount(code);
                }
                attractionMapper.updateKeywordCount(keywordCountDto);
            }
        }
        return attractionMapper.getAttractionListByKeyword(attractionKeywordSearchDto);
    }

    public AttractionDetailResponse getAttraction(int attractionId) {
        return attractionMapper.getAttraction(attractionId);
    }

    public List<AttractionMapResponse> getAttractionMapList(AttractionSearchDto attractionSearchDto) {
        attractionSearchDto.setSizePerPage(sizePerPage);
        attractionSearchDto.setStart(sizePerPage * attractionSearchDto.getPage());
        return attractionMapper.getAttractionMapList(attractionSearchDto);
    }

    public List<AttractionMapResponse> getAttractionMapListByUser(AttractionSearchDto attractionSearchDto) {
        attractionSearchDto.setSizePerPage(sizePerPage);
        attractionSearchDto.setStart(sizePerPage * attractionSearchDto.getPage());
        return attractionMapper.getAttractionMapListByUser(attractionSearchDto);
    }

    public List<InterestAttractionResponse> getInterestList(String userId) {
        return attractionMapper.getInterestList(userId);
    }

    public void registerInterest(InterestDto interestDto) {
        if(attractionMapper.getInterest(interestDto) == null) attractionMapper.registerInterest(interestDto);
    }

    public void deleteInterest(InterestDto interestDto) {
        attractionMapper.deleteInterest(interestDto);
    }
}