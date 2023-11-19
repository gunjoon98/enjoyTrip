package com.ssafy.enjoyTrip.web.user.payload;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserUpdate {
    private String pw;
    private String name;
}
