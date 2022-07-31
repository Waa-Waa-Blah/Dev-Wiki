package com.wwb.devwiki.domain.file.service;

import com.wwb.devwiki.domain.file.domain.File;
import com.wwb.devwiki.domain.file.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FileServiceImpl implements FileService{

    private final FileRepository fileRepository;

    @Override
    public List<File> saveFiles(List<File> files) {
        return fileRepository.saveAll(files);
    }
}
