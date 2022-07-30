package com.wwb.devwiki.domain.bookmark.service;

import com.wwb.devwiki.domain.board.domain.Board;
import com.wwb.devwiki.domain.board.service.BoardService;
import com.wwb.devwiki.domain.bookmark.domain.Bookmark;
import com.wwb.devwiki.domain.bookmark.repository.BookmarkRepository;
import com.wwb.devwiki.domain.member.domain.Member;
import com.wwb.devwiki.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookmarkServiceImpl implements BookmarkService{

    private final BookmarkRepository bookmarkRepository;
    private final MemberService memberService;
    private final BoardService boardService;

    @Override
    public Bookmark create(long memberId, long boardId) {
        Member member = memberService.findMemberById(memberId);
        Board board = boardService.findBoardById(boardId);
        Bookmark bookmark = Bookmark.of(member, board);
        return bookmarkRepository.save(bookmark);
    }
}
