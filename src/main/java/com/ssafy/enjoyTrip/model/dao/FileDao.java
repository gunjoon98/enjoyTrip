package com.ssafy.enjoyTrip.model.dao;

import org.springframework.web.multipart.MultipartFile;

public interface FileDao {
    void fileSave(MultipartFile mfile, String folderName, String fileName);
}
