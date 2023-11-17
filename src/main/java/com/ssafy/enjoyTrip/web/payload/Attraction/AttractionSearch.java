package com.ssafy.enjoyTrip.web.payload.Attraction;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
