package com.wwb.devwiki.domain.file.repository;

import com.wwb.devwiki.domain.file.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File,Long> {
}
