package com.wwb.devwiki.domain.board.service;

import com.wwb.devwiki.domain.board.domain.Board;
import com.wwb.devwiki.domain.board.dto.BoardReqDto;

public interface BoardService {

    Board writeBoard(BoardReqDto boardReqDto, Long loginUserId);


}
