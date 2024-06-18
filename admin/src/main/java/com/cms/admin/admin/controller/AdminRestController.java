package com.cms.admin.admin.controller;

import com.cms.admin.admin.dto.UserRequestDTO;
import com.cms.admin.admin.dto.WorshipRequestDTO;
import com.cms.admin.bulletin.service.BulletinService;
import com.cms.admin.common.dto.ResponseDto;
import com.cms.admin.user.exception.UsernameAlreadyFoundException;
import com.cms.admin.user.service.UserService;
import com.cms.admin.worship.service.WorshipService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminRestController {
    private final BulletinService bulletinService;
    private final WorshipService worshipService;
    private final UserService userService;

    @PostMapping("/worship")
    public ResponseEntity<ResponseDto> saveWorship(@RequestBody WorshipRequestDTO worshipRequestDTO) {
        worshipService.save(worshipRequestDTO);
        return ResponseEntity.ok(ResponseDto.ofSuccess());
    }

    @PostMapping("/user")
    public ResponseEntity<ResponseDto> saveUser(@RequestBody UserRequestDTO userRequestDTO) {
        userService.save(userRequestDTO);
        return ResponseEntity.ok(ResponseDto.ofSuccess());
    }

    @PostMapping(value = "/bulletin")
    public ResponseEntity<ResponseDto> saveBulletin(
            HttpSession session,
            @RequestPart("date") String date, @RequestPart("image1") MultipartFile image1, @RequestPart("image2")MultipartFile image2) {
        bulletinService.save((String)session.getAttribute("user"), date, image1, image2);
        return ResponseEntity.ok(ResponseDto.ofSuccess());
    }

    @ExceptionHandler(value = IOException.class)
    public ResponseEntity exceptionError(IOException e) {
        return ResponseEntity.badRequest().body(ResponseDto.ofUploadFail(e));
    }
    @ExceptionHandler(value = UsernameAlreadyFoundException.class)
    public ResponseEntity<ResponseDto<String>> usernameAlreadyFoundError(UsernameAlreadyFoundException e) {
        return ResponseEntity.badRequest().body(ResponseDto.ofSignupAlreadyUsernameFail(e));
    }


}
