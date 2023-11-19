package com.ssafy.enjoyTrip.model.admin.mapper;

import com.ssafy.enjoyTrip.model.admin.dto.*;
import com.ssafy.enjoyTrip.model.admin.response.*;
import java.util.List;

public interface AdminMapper {
    AttractionDetailResponse getAttraction(int attractionId);
    List<AttractionResponse> getAttractionList(AttractionSearchDto attractionSearchDto);
    //int updateAttraction(Attraction attraction);
    //int deleteAttraction(String attractionId);
    //int deleteImage(String imageId);
    int registerAttraction(AttractionRegisterDto attractionRegisterDto);
    int registerKeywordMatch(AttractionRegisterDto attractionRegisterDto);
    int registerImageInfo(List<ImageDto> imageDtoList);
}
