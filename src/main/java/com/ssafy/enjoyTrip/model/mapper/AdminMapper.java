package com.ssafy.enjoyTrip.model.mapper;

import com.ssafy.enjoyTrip.model.dto.Attraction;
import com.ssafy.enjoyTrip.model.dto.ImageInfo;

import java.util.List;
import java.util.Map;

public interface AdminMapper {
    List<Attraction> getAttractionList(Map<String, Object> map);
    Attraction getAttraction(int attractionId);
    int updateAttraction(Attraction attraction);
    //int deleteAttraction(String attractionId);
    //int deleteImage(String imageId);
    int registerAttraction(Attraction attraction);
    int registerKeywordMatch(Attraction attraction);
    int registerImageInfo(List<ImageInfo> imageInfos);
}
