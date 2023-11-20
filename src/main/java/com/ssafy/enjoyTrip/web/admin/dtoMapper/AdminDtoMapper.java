package com.ssafy.enjoyTrip.web.admin.dtoMapper;

import com.ssafy.enjoyTrip.model.admin.dto.*;
import com.ssafy.enjoyTrip.web.admin.payload.*;
import org.springframework.stereotype.Component;

@Component
public class AdminDtoMapper {
    public AttractionSearchDto attractionSearchToDto(AttractionSearch attractionSearch) {
        AttractionSearchDto attractionSearchDto = new AttractionSearchDto();
        attractionSearchDto.setPage(attractionSearch.getPage());
        attractionSearchDto.setTitle(attractionSearch.getTitle());
        attractionSearchDto.setCityCode(attractionSearch.getCityCode());
        return attractionSearchDto;
    }

    public AttractionRegisterDto attractionRegisterToDto(AttractionRegister attractionRegister) {
        AttractionRegisterDto attractionRegisterDto = new AttractionRegisterDto();
        attractionRegisterDto.setType(attractionRegister.getType());
        attractionRegisterDto.setAddress(attractionRegister.getAddress());
        attractionRegisterDto.setTitle(attractionRegister.getTitle());
        attractionRegisterDto.setCityCode(attractionRegister.getCityCode());
        attractionRegisterDto.setOverview(attractionRegister.getOverview());
        attractionRegisterDto.setLatitude(attractionRegister.getLatitude());
        attractionRegisterDto.setLongitude(attractionRegister.getLongitude());
        attractionRegisterDto.setKeywordCodes(attractionRegister.getKeywordCodes());
        return attractionRegisterDto;
    }
}
