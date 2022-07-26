package com.wwb.devwiki.domain.board.domain;

import com.wwb.devwiki.domain.file.domain.File;
import com.wwb.devwiki.domain.member.domain.Member;
import com.wwb.devwiki.domain.record.domain.Record;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id", updatable = false)
    private Long id;

    private String title;

    @Lob
    private String content;

    private long hit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member author;
    
    @OneToMany(mappedBy = "board")
    private List<Record> records = new ArrayList<>();

    @OneToMany(mappedBy = "board")
    private List<File> files = new ArrayList<>();

    private Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static Board of(String title, String content) {
        return new Board(title, content);
    }
}
