package com.ssafy.enjoyTrip.model.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Attraction {
    private Integer id;
    private Integer type;
    private String title;
    private String address;
    private Integer sidoCode;
    private Integer gugunCode;
    private String overview;
    private Double latitude;
    private Double longitude;
    private String mainImagePath;
    private List<Integer> keywordCodes;
    private List<Keyword> keywords;
    private List<ImageInfo> imageInfos;
}
