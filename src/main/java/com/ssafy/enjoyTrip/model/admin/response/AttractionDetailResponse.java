package com.ssafy.enjoyTrip.model.admin.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttractionDetailResponse {
    private Integer id;
    private Integer type;
    private String title;
    private String address;
    private Integer cityCode;
    private String overview;
    private Double latitude;
    private Double longitude;
    List<KeywordResponse> keywordResponses;
    List<ImageResponse> imageResponses;
}
