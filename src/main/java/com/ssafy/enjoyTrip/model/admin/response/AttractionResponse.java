package com.ssafy.enjoyTrip.model.admin.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttractionResponse {
    private Integer id;
    private String title;
    private String address;
    private String overview;
    private String mainImagePath;
}
