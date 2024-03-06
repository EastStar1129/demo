package com.cms.demo.admin.controller;

import com.cms.demo.admin.dto.WorshipRequestDTO;
import com.cms.demo.common.dto.ResponseDto;
import com.cms.demo.common.exception.FailedFileUploadException;
import com.cms.demo.worship.service.WorshipService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminRestController {
    private final WorshipService worshipService;

    @PostMapping("/worship")
    public ResponseEntity<ResponseDto> saveWorship(
            @RequestPart(value = "audio") MultipartFile audioFile,
            @RequestPart(value = "worship") WorshipRequestDTO worshipRequestDTO) {
        worshipService.save(worshipRequestDTO, audioFile);
        return ResponseEntity.ok(ResponseDto.ofSuccess());
    }

    @ExceptionHandler(value = IOException.class)
    public ResponseEntity exceptionError(Exception e) {
        return ResponseEntity.ok(ResponseDto.ofUploadFail());
    }
}
