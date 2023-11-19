package com.ssafy.enjoyTrip.model.user.dto;

import lombok.Value;

import java.util.List;

@Value
public class AttractionKeywordSearchDto {
    Integer cityCode;
    Integer column;
    List<Integer> keywordCodes;
}
