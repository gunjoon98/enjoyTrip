package com.ssafy.enjoyTrip.model.admin.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttractionRegisterDto {
    Integer id;
    Integer type;
    String title;
    String address;
    Integer cityCode;
    String overview;
    Double latitude;
    Double longitude;
    List<Integer> keywordCodes;
}


