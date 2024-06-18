package com.cms.client.bulletin.service;

import com.cms.client.bulletin.dto.BulletinResponseDTO;
import com.cms.database.bulletin.entity.Bulletin;
import com.cms.database.bulletin.repository.BulletinRepository;
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
}
