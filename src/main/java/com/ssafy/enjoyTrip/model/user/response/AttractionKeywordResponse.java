package com.ssafy.enjoyTrip.model.user.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttractionKeywordResponse {
    private Integer id;
    private String title;
    private String address;
    private String overview;
    private Double latitude;
    private Double longitude;
    private String mainImagePath;
}
