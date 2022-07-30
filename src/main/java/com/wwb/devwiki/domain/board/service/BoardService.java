package com.wwb.devwiki.domain.board.service;

import com.wwb.devwiki.domain.board.domain.Board;
import com.wwb.devwiki.domain.board.dto.BoardReqDto;

import java.util.List;

public interface BoardService {

    Board writeBoard(BoardReqDto boardReqDto, Long loginUserId);

    Board findBoardById(Long id);

    List<Board> findBoards();
}
