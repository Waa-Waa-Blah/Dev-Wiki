package com.wwb.devwiki.domain.bookmark.controller;

import com.wwb.devwiki.domain.bookmark.domain.Bookmark;
import com.wwb.devwiki.domain.bookmark.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RequestMapping("/api/bookmark")
@RestController
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @PostMapping("/board/{boardId}")
    public void create(@PathVariable Long boardId, HttpServletRequest request){
        Long loginUserId = (long) request.getSession(false).getAttribute("loginUser");
        bookmarkService.create(loginUserId, boardId);
    }

}
