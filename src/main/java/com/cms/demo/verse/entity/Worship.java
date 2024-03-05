package com.cms.demo.verse.entity;

import com.cms.demo.common.entity.DateEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Table(name = "tbl_verse")
public class Worship extends DateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_worship_seq")
    @SequenceGenerator(name = "tbl_worship_seq", sequenceName = "tbl_worship_seq", allocationSize = 1)
    private Long id;
    @Column
    private String date;
    @Column
    private String verses;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String audioPath;
    @Column
    private String writer;

    protected Worship() {}

    @Builder
    public Worship(Long id, String date, String verses, String title, String content, String audioPath, String writer) {
        this.id = id;
        this.date = date;
        this.verses = verses;
        this.title = title;
        this.content = content;
        this.audioPath = audioPath;
        this.writer = writer;
    }
}
