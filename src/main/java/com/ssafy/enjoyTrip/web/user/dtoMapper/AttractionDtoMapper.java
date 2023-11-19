package com.ssafy.enjoyTrip.web.user.dtoMapper;

import com.ssafy.enjoyTrip.model.user.dto.AttractionKeywordSearchDto;
import com.ssafy.enjoyTrip.model.user.dto.AttractionSearchDto;
import com.ssafy.enjoyTrip.model.user.dto.InterestDto;
import com.ssafy.enjoyTrip.web.user.payload.AttractionKeywordSearch;
import com.ssafy.enjoyTrip.web.user.payload.AttractionSearch;
import com.ssafy.enjoyTrip.web.user.payload.Interest;
import org.springframework.stereotype.Component;

@Component
public class AttractionDtoMapper {

    public AttractionKeywordSearchDto attractionKeywordSearchToDto(AttractionKeywordSearch attractionSearch) {
        return new AttractionKeywordSearchDto(
                attractionSearch.getCityCode(),
                attractionSearch.getColumn(),
                attractionSearch.getKeywordCodes());
    }

    public AttractionSearchDto attractionSearchToDto(AttractionSearch attractionSearch) {
        AttractionSearchDto attractionSearchDto =  new AttractionSearchDto();
        attractionSearchDto.setPage(attractionSearch.getPage());
        attractionSearchDto.setType(attractionSearch.getType());
        attractionSearchDto.setCityCode(attractionSearch.getCityCode());
        attractionSearchDto.setTitle(attractionSearch.getTitle());
        return attractionSearchDto;
    }

    public AttractionSearchDto attractionSearchToDto(AttractionSearch attractionSearch, String userId) {
        AttractionSearchDto attractionSearchDto =  new AttractionSearchDto();
        attractionSearchDto.setPage(attractionSearch.getPage());
        attractionSearchDto.setType(attractionSearch.getType());
        attractionSearchDto.setCityCode(attractionSearch.getCityCode());
        attractionSearchDto.setTitle(attractionSearch.getTitle());
        attractionSearchDto.setUserId(userId);
        return attractionSearchDto;
    }

    public InterestDto interestToDto(Interest interest, String userId) {
        return new InterestDto(interest.getAttractionId(), userId);
    }

    public InterestDto interestToDto(int attractionId, String userId) {
        return new InterestDto(attractionId, userId);
    }
}
