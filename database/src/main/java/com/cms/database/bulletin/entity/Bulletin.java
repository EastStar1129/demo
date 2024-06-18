package com.cms.database.bulletin.entity;

import com.cms.database.common.entity.DateEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tbl_bulletin")
public class Bulletin extends DateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    @Column
    private String date;
    @Column
    private String image1Path;
    @Column
    private String image2Path;
    @Column
    private String writer;

    public Bulletin(String date, String image1Path, String image2Path, String writer) {
        this.date = date;
        this.image1Path = image1Path;
        this.image2Path = image2Path;
        this.writer = writer;
    }

    public static Bulletin of(String date, String image1Path, String image2Path, String writer) {
        return new Bulletin(date, image1Path, image2Path, writer);
    }
}
