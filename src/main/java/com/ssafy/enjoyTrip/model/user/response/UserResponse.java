package com.ssafy.enjoyTrip.model.user.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String id;
    private String pw;
    private String role;
}
