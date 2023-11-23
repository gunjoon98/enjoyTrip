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

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    private final AdminDtoMapper adminDtoMapper;

    @GetMapping("/attractions")
    public ResponseEntity<?> getAttractionList(@Valid @ModelAttribute AttractionSearch attractionSearch) {
        return ResponseEntity.ok().body(adminService.getAttractionList(
                adminDtoMapper.attractionSearchToDto(attractionSearch)));
    }

    @GetMapping("/attraction/{id}")
    public ResponseEntity<?> getAttraction(@PathVariable("id") Integer attractionId) {
        return ResponseEntity.ok().body(adminService.getAttraction(attractionId));
    }

    @PostMapping("/attraction")
    public ResponseEntity<?> registerAttraction(@Valid @ModelAttribute AttractionRegister attractionRegister) {

        if(attractionRegister.getMainImage().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        List<MultipartFile> images = attractionRegister.getImages();
        for(int i=images.size()-1; i>=0; i--) {
            if(images.get(i).isEmpty()) images.remove(i);
        }

        List<Integer> keywordCodes = attractionRegister.getKeywordCodes();
        System.out.println(keywordCodes);
        for(int i=keywordCodes.size()-1; i>=0; i--) {
            if(keywordCodes.get(i) == null) keywordCodes.remove(i);
        }

        AttractionRegisterDto attractionRegisterDto = adminDtoMapper.attractionRegisterToDto(attractionRegister);
        adminService.registerAttraction(attractionRegisterDto, attractionRegister.getMainImage(),
                attractionRegister.getImages());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/attraction/{id}")
    public ResponseEntity<?> deleteAttraction(@PathVariable("id") int attractionId) {
        adminService.deleteAttraction(attractionId);
        return ResponseEntity.ok().build();
    }
}