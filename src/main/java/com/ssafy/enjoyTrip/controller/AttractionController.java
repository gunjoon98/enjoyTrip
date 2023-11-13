package com.ssafy.enjoyTrip.controller;

import com.ssafy.enjoyTrip.model.dto.Attraction;
import com.ssafy.enjoyTrip.model.dto.Keyword;
import com.ssafy.enjoyTrip.model.service.AttractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/sido")
    public ResponseEntity<?> getSidoList() {
        List<Map<String, Object>> sidos = attractionService.getSidoList();
        return ResponseEntity.ok().body(sidos);
    }

    @GetMapping("/keyword/attractions")
    public ResponseEntity<?> getAttractionList(@RequestBody Map<String, Object> map) {
        List<Attraction> attractions = attractionService.getAttractionList(map);
        return ResponseEntity.ok().body(attractions);
    }
}
