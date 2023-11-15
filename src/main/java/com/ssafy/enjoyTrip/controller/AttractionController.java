package com.ssafy.enjoyTrip.controller;

import com.ssafy.enjoyTrip.model.dto.Attraction;
import com.ssafy.enjoyTrip.model.dto.Keyword;
import com.ssafy.enjoyTrip.model.service.AttractionService;
import com.ssafy.enjoyTrip.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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
    public ResponseEntity<?> getAttractionListByKeyword(@RequestParam(required = false) List<Integer> keywordCodes, @RequestParam Integer cityCode,
                                               @RequestParam Integer column) {

        if(keywordCodes == null) keywordCodes = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("keywordCodes", keywordCodes);
        map.put("cityCode", cityCode);
        map.put("column", column);

        List<Attraction> attractions = attractionService.getAttractionListByKeyword(map);
        return ResponseEntity.ok().body(attractions);
    }

    @GetMapping("/map/attraction/{id}")
    public ResponseEntity<?> getAttraction(@PathVariable("id") Integer attractionId) {
        Attraction attraction = attractionService.getAttraction(attractionId);
        return ResponseEntity.ok().body(attraction);
    }

    @GetMapping("/map/attractions")
    public ResponseEntity<?> getAttractionMapList(@RequestParam Integer type, @RequestParam Integer page, @RequestParam Integer cityCode,
                                                  @RequestParam(required = false) String title, HttpServletRequest httpRequest) {
        if(title == null) title = "";
        Map<String, Object> map = new HashMap<>();
        map.put("type", type);
        map.put("page", page);
        map.put("cityCode", cityCode);
        map.put("title", title);

        String authorizationHeader = httpRequest.getHeader("Authorization");
        //로그인 X
        if(authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            return ResponseEntity.ok().body(attractionService.getAttractionMapList(map));
        }

        String token = authorizationHeader.substring(7);
        try {
            JWTUtil.validateToken(token);
        } catch (Exception e) {
            return ResponseEntity.status(401).build();
        }

        //로그인 O
        map.put("userId", JWTUtil.GetUserIdByToken(token));
        return ResponseEntity.ok().body(attractionService.getAttractionMapListByUser(map));
    }

    @GetMapping("/interests")
    public List<Attraction> getInterestList(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        String userId = JWTUtil.GetUserIdByToken(token);
        return attractionService.getInterestList(userId);
    }

    @PostMapping("/interest")
    public ResponseEntity<?> registerInterest(@RequestBody Map<String, Object> map, HttpServletRequest request) {
        if(map.get("attractionId") == null) return ResponseEntity.badRequest().build();

        String token = request.getHeader("Authorization");
        String userId = JWTUtil.GetUserIdByToken(token);
        Map<String, Object> params = new HashMap<>();
        params.put("attractionId", map.get("attractionId"));
        params.put("userId", userId);

        attractionService.registerInterest(params);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/interest/{id}")
    public ResponseEntity<?> deleteInterest(@PathVariable("id") int attractionId, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        String userId = JWTUtil.GetUserIdByToken(token);
        Map<String, Object> params = new HashMap<>();
        params.put("attractionId", attractionId);
        params.put("userId", userId);

        attractionService.deleteInterest(params);
        return ResponseEntity.ok().build();
    }
}
