package com.wwb.devwiki.domain.file.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long id;

    private String originName;

    private String path;

    private String hashName;

    private File(String originName, String path, String hashName) {
        this.originName = originName;
        this.path = path;
        this.hashName = hashName;
    }

    public static File of(String originName, String path, String hashName) {
        return new File(originName, path, hashName);
    }
}
