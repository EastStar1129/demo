package com.cms.demo.worship.service;

import com.cms.demo.admin.dto.WorshipRequestDTO;
import com.cms.demo.common.data.DemoData;
import com.cms.demo.common.exception.FailedFileUploadException;
import com.cms.demo.worship.dto.WorshipResponseDTO;
import com.cms.demo.worship.entity.Worship;
import com.cms.demo.worship.repository.WorshipRepository;
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
public class WorshipService {

    private final WorshipRepository worshipRepository;

    public WorshipService(WorshipRepository worshipRepository) {
        this.worshipRepository = worshipRepository;
    }

    public WorshipResponseDTO worship() {
        return WorshipResponseDTO.of(worshipRepository.findFirstByOrderByIdxDesc().orElse(null));
    }

    public List<WorshipResponseDTO> worships(int page) {
        Pageable pageable = PageRequest.of(page - 1, DemoData.WORSHIP_PAGE_SIZE);
        return WorshipResponseDTO.of(worshipRepository.findAll(pageable).getContent());
    }

    public void save(WorshipRequestDTO worshipRequestDTO, MultipartFile audioFile) {
        String fileName = "말씀_" + worshipRequestDTO.getDate() + "_" + worshipRequestDTO.getPart() + ".mp3";
        fileSave("/Users/donggyu/Desktop/workspace/upload/worship", fileName, audioFile);
        Worship worship = WorshipRequestDTO.toWorship(worshipRequestDTO, fileName);
        worshipRepository.save(worship);
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