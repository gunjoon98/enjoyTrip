package com.ssafy.enjoyTrip.controller;

import com.ssafy.enjoyTrip.model.dto.Attraction;
import com.ssafy.enjoyTrip.model.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/attraction")
    public ResponseEntity<?> getAttractionList(@RequestBody Map<String, Object> map) {
        List<Attraction> attractions = adminService.getAttractionList(map);
        return ResponseEntity.ok().body(attractions);
    }

    @GetMapping("/attraction/{id}")
    public ResponseEntity<?> getAttraction(@PathVariable("id") int attractionId) {
        Attraction attraction = adminService.getAttraction(attractionId);
        return ResponseEntity.ok().body(attraction);
    }

    @PostMapping("/attraction")
    public ResponseEntity<?> registerAttraction(@ModelAttribute Attraction attraction, @RequestParam MultipartFile mainImage, @RequestParam List<MultipartFile> images) {
        adminService.registerAttraction(attraction, mainImage, images);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/attraction/{id}")
    public ResponseEntity<?> updateAttraction(@ModelAttribute Attraction attraction, @RequestParam MultipartFile mainImage,
                                              @RequestParam List<MultipartFile> images, @RequestParam List<Integer> deleteImages) {
        return ResponseEntity.ok().build();
    }
}
