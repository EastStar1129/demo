package com.cms.demo.verse.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VerseDTO {
    private String title;
    private Integer chapter;
    private Integer startVerse;
    private Integer endVerse;
}
