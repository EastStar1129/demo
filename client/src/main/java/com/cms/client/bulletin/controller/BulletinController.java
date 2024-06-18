package com.cms.client.bulletin.controller;

import com.cms.client.bulletin.dto.BulletinResponseDTO;
import com.cms.client.bulletin.service.BulletinService;
import com.cms.client.common.dto.ResponseDto;
import com.cms.client.worship.dto.WorshipResponseDTO;
import com.cms.client.worship.service.WorshipService;
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
