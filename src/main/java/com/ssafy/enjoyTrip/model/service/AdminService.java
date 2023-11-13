package com.ssafy.enjoyTrip.model.service;

import com.ssafy.enjoyTrip.model.dao.FileDao;
import com.ssafy.enjoyTrip.model.dto.Attraction;
import com.ssafy.enjoyTrip.model.dto.ImageInfo;
import com.ssafy.enjoyTrip.model.mapper.AdminMapper;
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
    private final Map<Integer, String> folderMap;
    private final int sizePerPage = 12;

    @Autowired
    public AdminService(AdminMapper adminMapper, FileDao fileDao) {
        this.adminMapper = adminMapper;
        this.fileDao = fileDao;

        folderMap = new HashMap<>();
        folderMap.put(12, "tourlistSpots");
        folderMap.put(32, "accommodation");
        folderMap.put(39, "restaurant");
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
        adminMapper.registerKeywordMatch(attraction);

        List<ImageInfo> imageInfos = new ArrayList<>();

        ImageInfo imageInfo = new ImageInfo();
        String folderName = folderMap.get(attraction.getType());
        String originalImageName = mainImage.getOriginalFilename();
        String imageName = UUID.randomUUID() +
                originalImageName.substring(originalImageName.lastIndexOf('.'));

        imageInfo.setAttractionId(attraction.getId());
        imageInfo.setFolderName(folderName);
        imageInfo.setOriginalImageName(originalImageName);
        imageInfo.setImageName(imageName);
        imageInfo.setRepresentative(true);
        imageInfos.add(imageInfo);
        fileDao.fileSave(mainImage, folderName, imageName);

        for(MultipartFile image : images) {
            originalImageName = image.getOriginalFilename();
            imageName = UUID.randomUUID() +
                    originalImageName.substring(originalImageName.lastIndexOf('.'));

            imageInfo = new ImageInfo();
            imageInfo.setAttractionId(attraction.getId());
            imageInfo.setFolderName(folderName);
            imageInfo.setOriginalImageName(originalImageName);
            imageInfo.setImageName(imageName);
            imageInfo.setRepresentative(false);
            imageInfos.add(imageInfo);
            fileDao.fileSave(image, folderName, imageName);
        }

        adminMapper.registerImageInfo(imageInfos);
    }
}
