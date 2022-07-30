package com.wwb.devwiki.domain.board.controller;

import com.wwb.devwiki.domain.board.domain.Board;
import com.wwb.devwiki.domain.board.dto.BoardReqDto;
import com.wwb.devwiki.domain.board.dto.BoardResDto;
import com.wwb.devwiki.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public void writeBoard(@RequestBody BoardReqDto boardReqDto, HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse) throws IOException {
        Long loginUserId = (long) httpServletRequest.getSession(false).getAttribute("loginUser");
        Board board = boardService.writeBoard(boardReqDto, loginUserId);
        httpServletResponse.sendRedirect("/api/board/"+board.getId());
    }

    @GetMapping("/{id}")
    public BoardResDto findById(@PathVariable Long id){
        Board board = boardService.findBoardById(id);
        return BoardResDto.fromBoard(board);
    }

    @GetMapping
    public List<BoardResDto> findAll(){
        List<Board> boards = boardService.findBoards();
        return boards.stream().map(board -> BoardResDto.fromBoard(board)).collect(Collectors.toList());
    }

}
