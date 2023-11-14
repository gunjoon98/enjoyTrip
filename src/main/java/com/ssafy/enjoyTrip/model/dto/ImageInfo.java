package com.ssafy.enjoyTrip.model.dto;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonInclude;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageInfo {
    private Integer id;
    private Integer attractionId;
    private String imageName;
    private Boolean representative;
    private String imagePath;
}
