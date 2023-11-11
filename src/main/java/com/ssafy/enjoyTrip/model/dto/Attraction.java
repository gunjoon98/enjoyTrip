package com.ssafy.enjoyTrip.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attraction {
    private int id;
    private int type;
    private String title;
    private String address;
    private int sidoCode;
    private int gugunCode;
    private String overview;
    private double latitude;
    private double longitude;
}
