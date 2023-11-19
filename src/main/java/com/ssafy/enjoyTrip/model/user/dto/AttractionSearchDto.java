package com.ssafy.enjoyTrip.model.user.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttractionSearchDto {
    private Integer page;
    private Integer start;
    private Integer sizePerPage;
    private Integer type;
    private Integer cityCode;
    private String title;
    private String userId;
}
