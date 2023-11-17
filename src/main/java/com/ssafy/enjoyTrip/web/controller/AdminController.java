package com.ssafy.enjoyTrip.web.controller;

import com.ssafy.enjoyTrip.model.dto.Attraction;
import com.ssafy.enjoyTrip.model.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/attractions")
    public ResponseEntity<?> getAttractionList(@RequestParam(required = false) Integer cityCode, @RequestParam(required = false) String title,
                                               @RequestParam Integer page) {
        Map<String, Object> map = new HashMap<>();
        map.put("cityCode", cityCode);
        map.put("title", title);
        map.put("page", page);
        return ResponseEntity.ok().body(adminService.getAttractionList(map));
    }

    @GetMapping("/attraction/{id}")
    public ResponseEntity<?> getAttraction(@PathVariable("id") Integer attractionId) {
        return ResponseEntity.ok().body(adminService.getAttraction(attractionId));
    }

    @PostMapping("/attraction")
    public ResponseEntity<?> registerAttraction(@ModelAttribute Attraction attraction, @RequestParam MultipartFile mainImage,
                                                @RequestParam List<MultipartFile> images) {

        if(mainImage.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        List<MultipartFile> existImageList = new ArrayList<>();
        for(MultipartFile image : images) {
            if(!image.isEmpty()) existImageList.add(image);
        }

        List<Integer> keywordCodes = attraction.getKeywordCodes();
        for(int i=keywordCodes.size()-1; i>=0; i--) {
            if(keywordCodes.get(i) == null) keywordCodes.remove(i);
        }

        adminService.registerAttraction(attraction, mainImage, existImageList);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/attraction/{id}")
    public ResponseEntity<?> updateAttraction(@ModelAttribute Attraction attraction, @RequestParam MultipartFile mainImage,
                                              @RequestParam List<MultipartFile> images, @RequestParam List<Integer> deleteImages) {

        List<MultipartFile> existImageList = new ArrayList<>();
        for(MultipartFile image : images) {
            if(!image.isEmpty()) existImageList.add(image);
        }

        List<Integer> keywordCoses = attraction.getKeywordCodes();
        for(int i = keywordCoses.size()-1; i>=0; i--) {
            if(keywordCoses.get(i) == null) keywordCoses.remove(i);
        }

        return ResponseEntity.ok().build();
    }
}
