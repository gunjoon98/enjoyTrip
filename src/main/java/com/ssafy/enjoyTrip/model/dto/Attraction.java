package com.ssafy.enjoyTrip.model.dto;

import lombok.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Attraction {
    private Integer id;
    @NotNull
    private Integer type;
    @NotNull
    private String title;
    @NotNull
    private String address;
    @NotNull
    private Integer cityCode;
    private String overview;
    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;
    private String mainImagePath;
    private List<Integer> keywordCodes;
    private List<Keyword> keywords;
    private List<ImageInfo> imageInfos;
}
