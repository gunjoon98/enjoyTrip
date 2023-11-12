package com.ssafy.enjoyTrip.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String id;
    private String pw;
    private String email;
    private String name;
    private String registerDate;
    private Boolean isRemove;
    private String role;
}
