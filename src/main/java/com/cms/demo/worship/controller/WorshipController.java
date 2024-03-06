package com.cms.demo.worship.controller;

import com.cms.demo.common.dto.ResponseDto;
import com.cms.demo.worship.entity.Worship;
import com.cms.demo.worship.service.WorshipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/worship")
public class WorshipController {
    private final WorshipService worshipService;

    public WorshipController(WorshipService worshipService) {
        this.worshipService = worshipService;
    }

    @GetMapping("/worship")
    public ResponseEntity<ResponseDto<List<Worship>>> worship() {
        List<Worship> worships = worshipService.worships();
        return ResponseEntity.ok(new ResponseDto<>("", "", worships));
    }
}
