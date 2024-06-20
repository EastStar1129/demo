package com.cms.admin.worship.service;

import com.cms.admin.admin.dto.WorshipRequestDTO;
import com.cms.database.worship.entity.Worship;
import com.cms.database.worship.repository.WorshipRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WorshipService {

    private final WorshipRepository worshipRepository;
    public void save(WorshipRequestDTO worshipRequestDTO) {
        Worship worship = WorshipRequestDTO.toWorship(worshipRequestDTO);
        worshipRepository.saveAndFlush(worship);
    }
}