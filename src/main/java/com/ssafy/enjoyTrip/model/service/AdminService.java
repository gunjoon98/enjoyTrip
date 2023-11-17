package com.ssafy.enjoyTrip.model.service;

import com.ssafy.enjoyTrip.model.dao.FileDao;
import com.ssafy.enjoyTrip.model.dto.Attraction;
import com.ssafy.enjoyTrip.model.dto.ImageInfo;
import com.ssafy.enjoyTrip.model.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
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

    public List<Attraction> getAttractionList(Map<String, Object> map) {
        Map<String, Object> params = new HashMap<>();
        params.put("start", (int)map.get("page") * sizePerPage);
        params.put("sizePerPage", sizePerPage);
        params.put("cityCode", map.get("cityCode"));
        params.put("title", map.get("title"));
        return adminMapper.getAttractionList(params);
    }

    public Attraction getAttraction(int attractionId) {
        return adminMapper.getAttraction(attractionId);
    }

    @Transactional
    public void registerAttraction(Attraction attraction, MultipartFile mainImage, List<MultipartFile> images) {
        adminMapper.registerAttraction(attraction);
        if(attraction.getKeywordCodes() != null && !attraction.getKeywordCodes().isEmpty()) {
            adminMapper.registerKeywordMatch(attraction);
        }

        List<ImageInfo> imageInfos = new ArrayList<>();

        ImageInfo imageInfo = new ImageInfo();
        String imageName = mainImage.getOriginalFilename();
        String createdName = UUID.randomUUID() +
                imageName.substring(imageName.lastIndexOf('.'));
        String imagePath = "/image/" + createdName;
        imageInfo.setAttractionId(attraction.getId());
        imageInfo.setRepresentative(true);
        imageInfo.setImageName(imageName);
        imageInfo.setImagePath(imagePath);
        imageInfos.add(imageInfo);
        fileDao.fileSave(mainImage, createdName);

        for(MultipartFile image : images) {
            imageInfo = new ImageInfo();
            imageName = image.getOriginalFilename();
            createdName = UUID.randomUUID() +
                    imageName.substring(imageName.lastIndexOf('.'));
            imagePath = "/image/" + createdName;
            imageInfo.setAttractionId(attraction.getId());
            imageInfo.setRepresentative(false);
            imageInfo.setImageName(imageName);
            imageInfo.setImagePath(imagePath);
            imageInfos.add(imageInfo);
            fileDao.fileSave(image, createdName);
        }

        adminMapper.registerImageInfo(imageInfos);
    }

    @Transactional
    public void updateAttraction(Attraction attraction, MultipartFile mainImage,
                                 List<MultipartFile> images, List<Integer> deleteImages) {
        //1. attraction 수정
        //2. mainImage 저장, images 저장 -> imageImage 변경(DB 변경, 파일 삭제)
        //3. images 등록
        //4. deleteImages 삭제 ->
    }
}
