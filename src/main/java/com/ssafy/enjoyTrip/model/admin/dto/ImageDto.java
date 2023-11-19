package com.ssafy.enjoyTrip.model.admin.dto;

import lombok.Value;

@Value
public class ImageDto {
    Integer attractionId;
    String imageName;
    String imagePath;
    Boolean representative;
}
