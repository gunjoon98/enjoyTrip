package com.ssafy.enjoyTrip.web.user.payload;

import lombok.*;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Interest {
    @NotNull
    private Integer attractionId;
}
