package com.cms.client.bulletin.service;

import com.cms.client.bulletin.dto.BulletinResponseDTO;
import com.cms.database.bulletin.repository.BulletinRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BulletinService {
    public static final int BULLETIN_PAGE_SIZE = 10;
    private final BulletinRepositoryImpl bulletinRepositoryImpl;

    public BulletinResponseDTO bulletin() {
        return BulletinResponseDTO.of(bulletinRepositoryImpl.findFirstByOrderByIdxDesc().orElse(null));
    }

    public List<BulletinResponseDTO> bulletins(int page) {
        Pageable pageable = PageRequest.of(page - 1, BULLETIN_PAGE_SIZE);
        return BulletinResponseDTO.of(bulletinRepositoryImpl.findAll(pageable).getContent());
    }
}
