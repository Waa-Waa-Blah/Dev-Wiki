package com.wwb.devwiki.domain.file.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class FileTest {

    @Test
    @DisplayName("파일 생성 검증")
    public void fileCreateValid() throws Exception {
        //given
        File file = File.of("test","test/dd","201020200qkfoqkofq");

        assertAll(
                () -> assertThat(file.getOriginName()).isEqualTo("test"),
                () -> assertThat(file.getPath()).isEqualTo("test/dd"),
                () -> assertThat(file.getHashName()).isEqualTo("201020200qkfoqkofq")
        );
    }
}