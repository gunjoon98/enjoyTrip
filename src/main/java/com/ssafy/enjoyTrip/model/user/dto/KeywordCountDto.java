package com.ssafy.enjoyTrip.model.user.dto;

import lombok.Value;

import java.time.LocalDate;

@Value
public class KeywordCountDto {
    Integer keywordCode;
    LocalDate searchDate;
}
