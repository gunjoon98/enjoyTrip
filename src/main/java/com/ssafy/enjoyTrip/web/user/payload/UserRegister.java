package com.ssafy.enjoyTrip.web.user.payload;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRegister {
    @NotNull
    private String id;
    @NotNull
    private String pw;
    @NotNull
    private String email;
    @NotNull
    private String name;
}
