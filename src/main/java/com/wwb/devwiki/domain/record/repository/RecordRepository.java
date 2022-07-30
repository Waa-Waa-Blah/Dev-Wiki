package com.wwb.devwiki.domain.record.repository;

import com.wwb.devwiki.domain.record.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record,Long> {
}
