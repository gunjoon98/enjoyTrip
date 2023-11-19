package com.ssafy.enjoyTrip.model.admin.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageResponse {
    private Integer id;
    private String imagePath;
    private String imageName;
    private Boolean representative;
}
