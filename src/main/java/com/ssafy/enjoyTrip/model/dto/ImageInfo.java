package com.ssafy.enjoyTrip.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ImageInfo {
    private Integer id;
    private Integer attractionId;
    private String imageName;
    private String folderName;
    private String originalImageName;
    private Boolean representative;
    private String imagePath;
}
