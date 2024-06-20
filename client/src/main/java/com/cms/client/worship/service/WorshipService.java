package com.cms.client.worship.service;

import com.cms.client.common.data.DemoData;
import com.cms.client.worship.dto.WorshipResponseDTO;
import com.cms.database.worship.repository.WorshipRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WorshipService {

    private final WorshipRepository worshipRepository;

    public WorshipResponseDTO worship() {
        return WorshipResponseDTO.of(worshipRepository.findFirstByOrderByIdxDesc().orElse(null));
    }

    public List<WorshipResponseDTO> worships(int page) {
        Pageable pageable = PageRequest.of(page - 1, DemoData.WORSHIP_PAGE_SIZE);
        return WorshipResponseDTO.of(worshipRepository.findAll(pageable).getContent());
    }
}