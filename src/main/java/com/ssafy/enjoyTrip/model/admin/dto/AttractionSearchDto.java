package com.ssafy.enjoyTrip.model.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttractionSearchDto {
    private Integer start;
    private Integer sizePerPage;
    private Integer cityCode;
    private String title;
    private Integer page;
}
