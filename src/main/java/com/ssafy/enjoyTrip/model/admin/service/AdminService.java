package com.ssafy.enjoyTrip.model.admin.service;

import com.ssafy.enjoyTrip.model.admin.dto.*;
import com.ssafy.enjoyTrip.model.admin.mapper.AdminMapper;
import com.ssafy.enjoyTrip.model.admin.response.*;
import com.ssafy.enjoyTrip.model.dao.FileDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class AdminService {
    private final AdminMapper adminMapper;
    private final FileDao fileDao;
    //후에 전역 변수로 설정 필요
    private final int sizePerPage = 12;

    @Autowired
    public AdminService(AdminMapper adminMapper, FileDao fileDao) {
        this.adminMapper = adminMapper;
        this.fileDao = fileDao;
    }

    public List<AttractionResponse> getAttractionList(AttractionSearchDto attractionSearchDto) {
        attractionSearchDto.setSizePerPage(sizePerPage);
        attractionSearchDto.setStart(attractionSearchDto.getPage() * sizePerPage);
        return adminMapper.getAttractionList(attractionSearchDto);
    }

    public AttractionDetailResponse getAttraction(int attractionId) {
        return adminMapper.getAttraction(attractionId);
    }

    @Transactional
    public void registerAttraction(AttractionRegisterDto attractionRegisterDto, MultipartFile mainImage, List<MultipartFile> images) {
        adminMapper.registerAttraction(attractionRegisterDto);
        if(attractionRegisterDto.getKeywordCodes() != null && !attractionRegisterDto.getKeywordCodes().isEmpty()) {
            adminMapper.registerKeywordMatch(attractionRegisterDto);
        }

        List<ImageDto> imageDtoList = new ArrayList<>();

        String imageName = mainImage.getOriginalFilename();
        String createdName = UUID.randomUUID() +
                imageName.substring(imageName.lastIndexOf('.'));
        String imagePath = "/image/" + createdName;

        ImageDto imageDto = new ImageDto(
                attractionRegisterDto.getId(),
                imageName,
                imagePath,
                true);
        imageDtoList.add(imageDto);
        fileDao.fileSave(mainImage, createdName);

        for(MultipartFile image : images) {
            imageName = image.getOriginalFilename();
            createdName = UUID.randomUUID() +
                    imageName.substring(imageName.lastIndexOf('.'));
            imagePath = "/image/" + createdName;

            imageDto = new ImageDto(
                    attractionRegisterDto.getId(),
                    imageName,
                    imagePath,
                    true);
            imageDtoList.add(imageDto);
            fileDao.fileSave(image, createdName);
        }

        adminMapper.registerImageInfo(imageDtoList);
    }
}
