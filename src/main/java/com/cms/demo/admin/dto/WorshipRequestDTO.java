package com.cms.demo.admin.dto;

import com.cms.demo.worship.entity.Worship;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class WorshipRequestDTO {
    private List<VerseDTO> verses;
    private String title;
    private String content;
    private String date;
    private String part;

    //TODO: verses 생각
    public static Worship toWorship(WorshipRequestDTO worshipRequestDTO, String audioPath) {
        return Worship.builder()
                .title(worshipRequestDTO.getTitle())
                .content(worshipRequestDTO.getContent())
                .verses(makeVerses(worshipRequestDTO.getVerses()))
                .audioPath(audioPath)
                .date(worshipRequestDTO.getDate())
                .part(worshipRequestDTO.getPart())
                .build();
    }

    private static String makeVerses(List<VerseDTO> verses) {
        return verses.stream().map(VerseDTO::makeTitle).collect(Collectors.joining(", "));
    }
}
