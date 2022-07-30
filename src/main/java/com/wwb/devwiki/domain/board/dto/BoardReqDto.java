package com.wwb.devwiki.domain.board.dto;

import com.wwb.devwiki.domain.board.domain.Board;
import lombok.Getter;

@Getter
public class BoardReqDto {

    private String title;

    private String content;

    public Board toBoard(){
        return Board.of(title,content);
    }

}
