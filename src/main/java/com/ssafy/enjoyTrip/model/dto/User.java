package com.ssafy.enjoyTrip.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    private String pw;
    private String email;
    private String name;
    private String registerDate;
    private boolean isRemove;
    private String role;
}
