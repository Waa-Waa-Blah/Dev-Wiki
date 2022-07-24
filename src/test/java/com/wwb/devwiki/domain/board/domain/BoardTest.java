package com.wwb.devwiki.domain.board.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class BoardTest {

    @Test
    @DisplayName("게시글 생성 검증")
    public void boardCreateValid() throws Exception {
        //given
        Board board = Board.of("test", "content");

        assertAll(
                () -> assertThat(board.getTitle()).isEqualTo("test"),
                () -> assertThat(board.getContent()).isEqualTo("content"),
                () -> assertThat(board.getHit()).isZero()
        );
    }
}