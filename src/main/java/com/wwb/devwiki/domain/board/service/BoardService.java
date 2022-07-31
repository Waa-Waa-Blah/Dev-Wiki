package com.wwb.devwiki.domain.board.service;

import com.wwb.devwiki.domain.board.domain.Board;
import com.wwb.devwiki.domain.board.dto.BoardReqDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BoardService {

    Board writeBoard(BoardReqDto boardReqDto, Long loginUserId, List<MultipartFile> files) throws IOException;

    Board findBoardById(Long id);

    List<Board> findBoards();
}
