package com.wwb.devwiki.domain.bookmark.repository;

import com.wwb.devwiki.domain.bookmark.domain.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark,Long> {
}
