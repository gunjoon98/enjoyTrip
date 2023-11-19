package com.ssafy.enjoyTrip.model.user.dto;

import lombok.Value;

@Value
public class UserRegisterDto {
    String id;
    String pw;
    String email;
    String name;
    String role;
}
