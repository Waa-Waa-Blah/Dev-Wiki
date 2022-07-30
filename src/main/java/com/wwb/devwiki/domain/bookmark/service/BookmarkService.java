package com.wwb.devwiki.domain.bookmark.service;

import com.wwb.devwiki.domain.bookmark.domain.Bookmark;

public interface BookmarkService {

    Bookmark create(long memberId, long boardId);
}
