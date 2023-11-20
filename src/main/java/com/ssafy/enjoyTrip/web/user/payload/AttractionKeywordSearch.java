package com.ssafy.enjoyTrip.web.user.payload;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AttractionKeywordSearch {
    @NotNull
    private Integer cityCode;
    @NotNull
    private Integer column;
    private List<@NotNull Integer> keywordCodes;
}
