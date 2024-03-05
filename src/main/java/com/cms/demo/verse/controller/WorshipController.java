package com.cms.demo.verse.controller;

import com.cms.demo.common.dto.ResponseDto;
import com.cms.demo.verse.dto.WorshipRequestDTO;
import com.cms.demo.verse.entity.Worship;
import com.cms.demo.verse.service.WorshipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorshipController {
    private final WorshipService worshipService;

    public WorshipController(WorshipService worshipService) {
        this.worshipService = worshipService;
    }

    @GetMapping("worship")
    public ResponseEntity<ResponseDto<List<Worship>>> worship() {
        List<Worship> worships = worshipService.worships();
        return ResponseEntity.ok(new ResponseDto<>("", "", worships));
    }

    @PostMapping("worship")
    public ResponseEntity<ResponseDto> saveVerse(WorshipRequestDTO worshipRequestDTO) {
        worshipService.save(worshipRequestDTO);
        return ResponseEntity.ok(ResponseDto.ofSuccess());
    }
}
