package com.cms.demo.verse.dto;

import com.cms.demo.verse.entity.Worship;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class WorshipRequestDTO {
    @Column
    private List<VerseDTO> verses;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String audioPath;
    @Column
    private String writer;

    //TODO: verses 생각
    public static Worship toVerse(WorshipRequestDTO worshipRequestDTO) {
        return Worship.builder()
                .title(worshipRequestDTO.getTitle())
                .content(worshipRequestDTO.getContent())
                .audioPath(worshipRequestDTO.getAudioPath())
                .build();
    }
}
