package com.ssafy.enjoyTrip.model.user.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttractionDetailResponse {
    private Integer id;
    private Integer type;
    private String title;
    private String address;
    private String overview;
    private Double latitude;
    private Double longitude;
    private List<ImageResponse> imageResponses;
}
