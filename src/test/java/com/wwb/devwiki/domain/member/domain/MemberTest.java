package com.wwb.devwiki.domain.member.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;


class MemberTest {

    @Test
    @DisplayName("회원 생성 검증")
    public void memberCreateValid() throws Exception {
        //given
        Member member = Member.of("test", "test", "123", "010-5751-5232", true);

        assertAll(
                () -> assertThat(member.getRealName()).isEqualTo("test"),
                () -> assertThat(member.getNickname()).isEqualTo("test"),
                () -> assertThat(member.getPassword()).isEqualTo("123"),
                () -> assertThat(member.getPhoneNumber()).isEqualTo("010-5751-5232"),
                () -> assertThat(member.isAccountActive()).isTrue()
        );
    }
}