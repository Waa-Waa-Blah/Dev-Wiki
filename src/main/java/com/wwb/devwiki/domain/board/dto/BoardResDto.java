package com.wwb.devwiki.domain.board.dto;

import com.wwb.devwiki.domain.board.domain.Board;
import com.wwb.devwiki.domain.file.dto.FileResDto;
import com.wwb.devwiki.domain.member.dto.MemberResDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class BoardResDto {

    private String title;

    private String content;

    private long hit;

    private MemberResDto author;

    private List<FileResDto> files;

    public static BoardResDto fromBoard(Board board) {
        return new BoardResDto(
                board.getTitle(),
                board.getContent(),
                board.getHit(),
                MemberResDto.toMember(board.getAuthor()),
                board.getFiles().stream().map(file -> FileResDto.fromFile(file)).collect(Collectors.toList())
        );
    }
}
