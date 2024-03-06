package com.cms.demo.admin.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VerseDTO {
    private String bible;
    private Integer chapter;
    private Integer startVerse;
    private Integer endVerse;

    public String makeTitle() {
        return bible + " " + chapter + " : " + startVerse + "~" + endVerse;
    }
}
