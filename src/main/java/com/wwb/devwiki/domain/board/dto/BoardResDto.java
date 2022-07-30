package com.wwb.devwiki.domain.board.dto;

import com.wwb.devwiki.domain.board.domain.Board;
import com.wwb.devwiki.domain.member.dto.MemberResDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BoardResDto {

    private String title;

    private String content;

    private long hit;

    private MemberResDto author;

    public static BoardResDto fromBoard(Board board) {
        return new BoardResDto(
                board.getTitle(),
                board.getContent(),
                board.getHit(),
                MemberResDto.toMember(board.getAuthor())
        );
    }
}
