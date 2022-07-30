package com.wwb.devwiki.domain.record.service;

import com.wwb.devwiki.domain.board.domain.Board;
import com.wwb.devwiki.domain.record.domain.Record;
import com.wwb.devwiki.domain.record.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class RecordServiceImpl implements RecordService {

    private final RecordRepository recordRepository;

    @Override
    public Record createRecord(String title, String content, long hit, long version, Board board) {
        Record record = Record.of(title, content, hit, 0L, board);
        return recordRepository.save(record);
    }

}
