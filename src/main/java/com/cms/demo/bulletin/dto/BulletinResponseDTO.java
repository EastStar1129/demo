package com.cms.demo.bulletin.dto;

import com.cms.demo.bulletin.entity.Bulletin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BulletinResponseDTO {
    private Long idx;
    private String date;
    private String image1Path;
    private String image2Path;
    private String writer;

    public static List<BulletinResponseDTO> of(List<Bulletin> list) {
        return list.stream().map(BulletinResponseDTO::of).collect(Collectors.toList());
    }

    public static BulletinResponseDTO of(Bulletin bulletin) {
        return new BulletinResponseDTO(bulletin.getIdx(), bulletin.getDate(), bulletin.getImage1Path(), bulletin.getImage2Path(), bulletin.getWriter());
    }
}
