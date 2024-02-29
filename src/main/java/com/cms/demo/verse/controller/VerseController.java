//package com.cms.demo.verse.controller;
//
//import com.cms.demo.main.dto.ResponseDto;
//import com.cms.demo.main.service.VerseService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class VerseController {
//    private final VerseService verseService;
//
//    public VerseController(VerseService verseService) {
//        this.verseService = verseService;
//    }
//
//    @GetMapping("verses")
//    public ResponseEntity<ResponseDto> verses() {
//        List verses = verseService.verses();
//        return ResponseEntity.ok(new ResponseDto("", "", verses));
//    }
//}
