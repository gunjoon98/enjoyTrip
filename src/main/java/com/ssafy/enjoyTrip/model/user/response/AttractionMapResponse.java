package com.ssafy.enjoyTrip.model.user.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttractionMapResponse {
    private Integer id;
    private Integer type;
    private String title;
    private String address;
    private String overview;
    private String mainImagePath;
    private Double latitude;
    private Double longitude;
    private Boolean interest;
}