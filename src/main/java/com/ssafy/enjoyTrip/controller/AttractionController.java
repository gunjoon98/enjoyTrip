package com.ssafy.enjoyTrip.controller;

import com.ssafy.enjoyTrip.model.dto.Attraction;
import com.ssafy.enjoyTrip.model.dto.Keyword;
import com.ssafy.enjoyTrip.model.service.AttractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AttractionController {
    private final AttractionService attractionService;

    @GetMapping("/keywords")
    public ResponseEntity<?> getKeywordList() {
        List<Keyword> keywords = attractionService.getKeywordList();
        return ResponseEntity.ok().body(keywords);
    }

    @GetMapping("/cities")
    public ResponseEntity<?> getCityList() {
        List<Map<String, Object>> cities = attractionService.getcityList();
        return ResponseEntity.ok().body(cities);
    }

    @GetMapping("/keyword/attractions")
    public ResponseEntity<?> getAttractionList(@RequestParam List<Integer> keywordCodes, @RequestParam int cityCode,
                                               @RequestParam int column) {
        Map<String, Object> map = new HashMap<>();
        map.put("keywordCodes", keywordCodes);
        map.put("cityCode", cityCode);
        map.put("column", column);

        List<Attraction> attractions = attractionService.getAttracionList(map);
        return ResponseEntity.ok().body(attractions);
    }

    @GetMapping("/map/attraction/{id}")
    public ResponseEntity<?> getAttraction(@PathVariable("id") int attractionId) {
        Attraction attraction = attractionService.getAttraction(attractionId);
        return ResponseEntity.ok().body(attraction);
    }
}
