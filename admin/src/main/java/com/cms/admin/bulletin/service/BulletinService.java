package com.cms.admin.bulletin.service;

import com.cms.admin.common.exception.FailedFileUploadException;
import com.cms.database.bulletin.entity.Bulletin;
import com.cms.database.bulletin.repository.BulletinRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@AllArgsConstructor
public class BulletinService {
    private final BulletinRepositoryImpl bulletinRepositoryImpl;
    private final String PREFIX_PATH = "/Users/youngseok/upload/bulletin";

    public void save(String username, String date, MultipartFile image1, MultipartFile image2) {
        String fileName1 = date + "_1.jpeg";
        String fileName2 = date + "_2.jpeg";
        fileSave(PREFIX_PATH, fileName1, image1);
        fileSave(PREFIX_PATH, fileName2, image2);
        Bulletin bulletin = Bulletin.of(date, fileName1, fileName2, username);
        bulletinRepositoryImpl.saveAndFlush(bulletin);
    }

    public void fileSave(String directory, String fileName, MultipartFile file) {
        Path filePath = Paths.get(directory, fileName);
        try {
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, file.getBytes());
        } catch (IOException e) {
            throw new FailedFileUploadException(e);
        }
    }
}
