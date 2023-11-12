package com.ssafy.enjoyTrip.model.dao;

import com.ssafy.enjoyTrip.model.exception.FileDaoException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileDaoImpl implements FileDao {

    @Value("${image-upload-path}")
    private String uploadPath;

    public void fileSave(MultipartFile mfile, String folderName, String fileName) {
        Path path = Paths.get(uploadPath + '/' + folderName + '/' + fileName);
        try{
            mfile.transferTo(path);
        } catch (IOException ioException) {
            throw new FileDaoException(ioException);
        }
    }
}
