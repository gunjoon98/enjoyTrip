package com.ssafy.enjoyTrip.web.admin.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttractionRegister {
    @NotNull
    private Integer type;
    @NotNull
    private String title;
    @NotNull
    private String address;
    @NotNull
    private Integer cityCode;
    @NotNull
    private String overview;
    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;
    private List<Integer> keywordCodes;
    @NotNull
    private MultipartFile mainImage;
    private List<@NotNull MultipartFile> images;
}
