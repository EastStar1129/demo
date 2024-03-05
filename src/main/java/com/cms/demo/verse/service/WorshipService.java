package com.cms.demo.verse.service;

import com.cms.demo.verse.dto.WorshipRequestDTO;
import com.cms.demo.verse.entity.Worship;
import com.cms.demo.verse.repository.WorshipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorshipService {
    private final WorshipRepository worshipRepository;

    public WorshipService(WorshipRepository worshipRepository) {
        this.worshipRepository = worshipRepository;
    }

    public List<Worship> worships() {
        return worshipRepository.findAll();
    }

    public void save(WorshipRequestDTO worshipRequestDTO) {
        Worship verse = WorshipRequestDTO.toVerse(worshipRequestDTO);
        worshipRepository.save(verse);
    }
}