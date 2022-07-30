package com.wwb.devwiki.domain.board.controller;

import com.wwb.devwiki.domain.board.dto.BoardReqDto;
import com.wwb.devwiki.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public void writeBoard(@RequestBody BoardReqDto boardReqDto, HttpServletRequest httpServletRequest) {
        Long loginUserId = (long) httpServletRequest.getSession(false).getAttribute("loginUser");
        boardService.writeBoard(boardReqDto, loginUserId);
    }

}
