package com.wwb.devwiki.domain.file.dto;

import com.wwb.devwiki.domain.file.domain.File;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FileResDto {

    private Long id;

    private String fileName;

    private String filePath;

    public static FileResDto fromFile(File file) {
        return new FileResDto(file.getId(),file.getOriginName(),file.getPath());
    }
}
