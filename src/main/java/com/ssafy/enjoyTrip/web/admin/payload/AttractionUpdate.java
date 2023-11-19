package com.ssafy.enjoyTrip.web.admin.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttractionUpdate {
    private Integer id;
    private Integer type;
    private String title;
    private String address;
    private Double latitude;
    private Double longitude;
    private String overview;
    private Integer cityCode;
    private List<Integer> keywordCodes;
    private MultipartFile mainImage;
    private List<MultipartFile> deleteImages;
}
