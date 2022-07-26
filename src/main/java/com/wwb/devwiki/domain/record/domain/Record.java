package com.wwb.devwiki.domain.record.domain;

import com.wwb.devwiki.domain.board.domain.Board;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id", updatable = false)
    private Long id;

    private String title;

    @Lob
    private String content;

    private long hit;

    private long version;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    private Record(String title, String content, long hit, long version) {
        this.title = title;
        this.content = content;
        this.hit = hit;
        this.version = version;
    }

    public static Record of(String title, String content, long hit, long version) {
        return new Record(title, content, hit, version);
    }
}
