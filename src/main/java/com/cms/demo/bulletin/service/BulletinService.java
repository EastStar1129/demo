package com.cms.demo.bulletin.service;

import com.cms.demo.admin.dto.WorshipRequestDTO;
import com.cms.demo.bulletin.dto.BulletinResponseDTO;
import com.cms.demo.bulletin.entity.Bulletin;
import com.cms.demo.bulletin.repository.BulletinRepository;
import com.cms.demo.common.data.DemoData;
import com.cms.demo.common.exception.FailedFileUploadException;
import com.cms.demo.worship.dto.WorshipResponseDTO;
import com.cms.demo.worship.entity.Worship;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@AllArgsConstructor
public class BulletinService {
    public static final int BULLETIN_PAGE_SIZE = 10;
    private final BulletinRepository bulletinRepository;

    public BulletinResponseDTO bulletin() {
        return BulletinResponseDTO.of(bulletinRepository.findFirstByOrderByIdxDesc().orElse(null));
    }

    public List<BulletinResponseDTO> bulletins(int page) {
        Pageable pageable = PageRequest.of(page - 1, BULLETIN_PAGE_SIZE);
        return BulletinResponseDTO.of(bulletinRepository.findAll(pageable).getContent());
    }

    public void save(WorshipRequestDTO worshipRequestDTO, MultipartFile image1, MultipartFile image2) {
        String fileName1 = "주보_" + worshipRequestDTO.getDate() + "_1.jpeg";
        String fileName2 = "주보_" + worshipRequestDTO.getDate() + "_2.jpeg";
        fileSave("/Users/donggyu/Desktop/workspace/upload/bulletin", fileName1, image1);
        fileSave("/Users/donggyu/Desktop/workspace/upload/bulletin", fileName2, image2);
        Bulletin bulletin = null;
        bulletinRepository.save(bulletin);
    }

    public void fileSave(String directory, String fileName, MultipartFile file) {
        Path filePath = Paths.get(directory, fileName);
        try {
            Files.write(filePath, file.getBytes());
        } catch (IOException e) {
            throw new FailedFileUploadException(e);
        }
    }
}
