package com.cms.demo.worship.entity;

import com.cms.demo.common.entity.DateEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Table(name = "tbl_worship")
public class Worship extends DateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    @Column
    private String part;
    @Column
    private String date;
    @Column
    private String verses;
    @Column
    private String title;
    @Column(length = 4000)
    private String content;
    @Column
    private String audioPath;
    @Column
    private String writer;

    protected Worship() {}

    @Builder
    public Worship(Long idx, String part, String date, String verses, String title, String content, String audioPath, String writer) {
        this.idx = idx;
        this.part = part;
        this.date = date;
        this.verses = verses;
        this.title = title;
        this.content = content;
        this.audioPath = audioPath;
        this.writer = writer;
    }
}
