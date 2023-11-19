package com.ssafy.enjoyTrip.model.user.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageResponse {
    private String imageName;
    private Boolean representative;
    private String imagePath;
}
