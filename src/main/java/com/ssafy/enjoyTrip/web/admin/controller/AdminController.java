package com.ssafy.enjoyTrip.web.admin.controller;

import com.ssafy.enjoyTrip.model.admin.dto.AttractionRegisterDto;
import com.ssafy.enjoyTrip.model.admin.service.AdminService;
import com.ssafy.enjoyTrip.web.admin.dtoMapper.AdminDtoMapper;
import com.ssafy.enjoyTrip.web.admin.payload.AttractionRegister;
import com.ssafy.enjoyTrip.web.admin.payload.AttractionSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    private final AdminDtoMapper adminDtoMapper;

    @GetMapping("/attractions")
    public ResponseEntity<?> getAttractionList(@ModelAttribute AttractionSearch attractionSearch) {
        return ResponseEntity.ok().body(adminService.getAttractionList(
                adminDtoMapper.attractionSearchToDto(attractionSearch)));
    }

    @GetMapping("/attraction/{id}")
    public ResponseEntity<?> getAttraction(@PathVariable("id") Integer attractionId) {
        return ResponseEntity.ok().body(adminService.getAttraction(attractionId));
    }

    @PostMapping("/attraction")
    public ResponseEntity<?> registerAttraction(@ModelAttribute AttractionRegister attractionRegister) {

        if(attractionRegister.getMainImage().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        System.out.println(attractionRegister.getKeywordCodes());

        List<MultipartFile> images = attractionRegister.getImages();
        for(int i=images.size()-1; i>=0; i--) {
            if(images.get(i).isEmpty()) images.remove(i);
        }

        AttractionRegisterDto attractionRegisterDto = adminDtoMapper.attractionRegisterToDto(attractionRegister);
        adminService.registerAttraction(attractionRegisterDto, attractionRegister.getMainImage(),
                attractionRegister.getImages());
        return ResponseEntity.ok().build();
    }
}