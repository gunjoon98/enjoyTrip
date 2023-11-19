package com.ssafy.enjoyTrip.web.admin.payload;

import lombok.*;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AttractionSearch {
    private Integer cityCode;
    private String title;
    @NotNull
    private Integer page;
}
