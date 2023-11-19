package com.ssafy.enjoyTrip.web.user.payload;

import lombok.*;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AttractionSearch {
    @NotNull
    private Integer type;
    @NotNull
    private Integer cityCode;
    @NotNull
    private Integer page;
    private String title;
}
