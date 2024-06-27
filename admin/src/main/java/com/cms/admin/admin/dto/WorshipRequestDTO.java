package com.cms.admin.admin.dto;

import com.cms.database.worship.entity.Worship;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class WorshipRequestDTO {
    private String verses;
    private String title;
    private String content;
    private String date;
    private String part;
    private String audioPath;

    public static Worship toWorship(WorshipRequestDTO worshipRequestDTO) {
        return Worship.builder()
                .title(worshipRequestDTO.getTitle())
                .content(worshipRequestDTO.getContent())
                .verses(worshipRequestDTO.getVerses())
                .audioPath(worshipRequestDTO.getAudioPath())
                .date(worshipRequestDTO.getDate().replaceAll("\"", ""))
                .part(worshipRequestDTO.getPart())
                .build();
    }
}
