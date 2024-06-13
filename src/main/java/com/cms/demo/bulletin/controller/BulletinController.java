package com.cms.demo.bulletin.controller;

import com.cms.demo.bulletin.dto.BulletinResponseDTO;
import com.cms.demo.bulletin.service.BulletinService;
import com.cms.demo.common.dto.ResponseDto;
import com.cms.demo.worship.dto.WorshipResponseDTO;
import com.cms.demo.worship.service.WorshipService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bulletin")
public class BulletinController {
    private final BulletinService bulletinService;

    @GetMapping("/bulletin")
    public ResponseEntity<ResponseDto<BulletinResponseDTO>> bulletin() {
        BulletinResponseDTO bulletin = bulletinService.bulletin();
        return ResponseEntity.ok(ResponseDto.ofSuccess(bulletin));
    }

    @GetMapping("/bulletins")
    public ResponseEntity<ResponseDto<List<BulletinResponseDTO>>> bulletins(@RequestParam(defaultValue = "1") int page) {
        List<BulletinResponseDTO> bulletins = bulletinService.bulletins(page);
        return ResponseEntity.ok(ResponseDto.ofSuccess(bulletins));
    }
}
