package com.cms.demo.worship.dto;

import com.cms.demo.worship.entity.Worship;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class WorshipResponseDTO {
    private Long idx;
    private String part;
    private String date;
    private String verses;
    private String title;
    private String content;
    private String writer;

    public static List<WorshipResponseDTO> of(List<Worship> list) {
        return list.stream().map(WorshipResponseDTO::of).collect(Collectors.toList());
    }

    public static WorshipResponseDTO of(Worship worship) {
        return WorshipResponseDTO.builder()
                .idx(worship.getIdx())
                .part(worship.getPart())
                .date(worship.getDate())
                .verses(worship.getVerses())
                .title(worship.getTitle())
                .content(worship.getContent())
                .writer(worship.getWriter())
                .build();
    }
}
