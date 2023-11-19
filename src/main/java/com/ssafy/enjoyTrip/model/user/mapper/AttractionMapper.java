package com.ssafy.enjoyTrip.model.user.mapper;

import com.ssafy.enjoyTrip.model.user.dto.*;
import com.ssafy.enjoyTrip.model.user.response.*;

import java.util.List;
import java.util.Map;

public interface AttractionMapper {
    List<KeywordResponse> getKeywordList();
    List<CityResponse> getcityList();
    List<AttractionKeywordResponse> getAttractionListByKeyword(AttractionKeywordSearchDto attractionKeywordSearchDto);
    AttractionDetailResponse getAttraction(int attractionId);
    List<AttractionMapResponse> getAttractionMapList(AttractionSearchDto attractionSearchDto);
    List<AttractionMapResponse> getAttractionMapListByUser(AttractionSearchDto attractionSearchDto);
    List<InterestAttractionResponse> getInterestList(String userId);
    Integer getKeywordCount(KeywordCountDto keywordCountDto);
    String getInterest(InterestDto interestDto);
    int registerKeywordCount(int keywordCode);
    int updateKeywordCount(KeywordCountDto keywordCountDto);
    int registerInterest(InterestDto interestDto);
    int deleteInterest(InterestDto interestDto);
}
