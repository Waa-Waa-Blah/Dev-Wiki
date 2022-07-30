package com.wwb.devwiki.domain.record.service;

import com.wwb.devwiki.domain.board.domain.Board;
import com.wwb.devwiki.domain.record.domain.Record;

public interface RecordService {

    Record createRecord(String title, String content, long hit, long version, Board board);
}
