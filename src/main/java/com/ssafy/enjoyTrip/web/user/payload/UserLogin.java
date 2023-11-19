package com.ssafy.enjoyTrip.web.user.payload;

import lombok.*;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserLogin {
    @NotNull
    private String id;
    @NotNull
    private String pw;
}
