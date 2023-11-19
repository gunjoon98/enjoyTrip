package com.ssafy.enjoyTrip.web.user.controller;

import com.ssafy.enjoyTrip.model.user.dto.InterestDto;
import com.ssafy.enjoyTrip.util.JWTUtil;
import com.ssafy.enjoyTrip.web.user.dtoMapper.AttractionDtoMapper;
import com.ssafy.enjoyTrip.web.user.payload.*;
import com.ssafy.enjoyTrip.model.user.response.*;
import com.ssafy.enjoyTrip.model.user.service.AttractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AttractionController {
    private final AttractionService attractionService;
    private final AttractionDtoMapper attractionDtoMapper;

    @GetMapping("/keywords")
    public ResponseEntity<?> getKeywordList() {
        List<KeywordResponse> keywords = attractionService.getKeywordList();
        return ResponseEntity.ok().body(keywords);
    }

    @GetMapping("/cities")
    public ResponseEntity<?> getCityList() {
        List<CityResponse> cities = attractionService.getcityList();
        return ResponseEntity.ok().body(cities);
    }

    @GetMapping("/keyword/attractions")
    public ResponseEntity<?> getAttractionListByKeyword(@ModelAttribute AttractionKeywordSearch attractionKeywordSearch) {

        List<AttractionKeywordResponse> attractions = attractionService.getAttractionListByKeyword(
                attractionDtoMapper.attractionKeywordSearchToDto(attractionKeywordSearch));
        return ResponseEntity.ok().body(attractions);
    }

    @GetMapping("/map/attraction/{id}")
    public ResponseEntity<?> getAttraction(@PathVariable("id") Integer attractionId) {
        AttractionDetailResponse attraction = attractionService.getAttraction(attractionId);
        return ResponseEntity.ok().body(attraction);
    }

    @GetMapping("/map/attractions")
    public ResponseEntity<?> getAttractionMapList(@ModelAttribute AttractionSearch attractionSearch, HttpServletRequest httpRequest) {
        String authorizationHeader = httpRequest.getHeader("Authorization");

        //로그인 X
        if(authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            return ResponseEntity.ok().body(attractionService.getAttractionMapList(
                    attractionDtoMapper.attractionSearchToDto(attractionSearch)));
        }

        String token = authorizationHeader.substring(7);
        try {
            JWTUtil.validateToken(token);
        } catch (Exception e) {
            return ResponseEntity.status(401).build();
        }

        //로그인 O
        String userId = JWTUtil.getUserId(token);
        return ResponseEntity.ok().body(attractionService.getAttractionMapListByUser(
                attractionDtoMapper.attractionSearchToDto(attractionSearch, userId)));
    }

    @GetMapping("/interests")
    public ResponseEntity<?> getInterestList(HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        return ResponseEntity.ok().body(attractionService.getInterestList(userId));
    }

    @PostMapping("/interest")
    public ResponseEntity<?> registerInterest(@RequestBody Interest interest, HttpServletRequest request) {
        InterestDto interestDto = attractionDtoMapper.interestToDto(interest, (String) request.getAttribute("userId"));
        attractionService.registerInterest(interestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/interest/{id}")
    public ResponseEntity<?> deleteInterest(@PathVariable("id") int attractionId, HttpServletRequest request) {
        InterestDto interestDto = attractionDtoMapper.interestToDto(attractionId, (String) request.getAttribute("userId"));
        attractionService.deleteInterest(interestDto);
        return ResponseEntity.ok().build();
    }
}