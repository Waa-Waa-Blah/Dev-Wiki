package com.wwb.devwiki.domain.file.service;

import com.wwb.devwiki.domain.file.domain.File;

import java.util.List;

public interface FileService {

    List<File> saveFiles(List<File> files);

}
