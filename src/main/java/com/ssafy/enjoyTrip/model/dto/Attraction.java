package com.ssafy.enjoyTrip.model.dto;

import lombok.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Attraction {
    private Integer id;
    private Integer type;
    private String title;
    private String address;
    private Integer cityCode;
    private String overview;
    private Double latitude;
    private Double longitude;
    private String mainImagePath;
    private List<Integer> keywordCodes;
    private List<Keyword> keywords;
    private List<ImageInfo> imageInfos;
}
