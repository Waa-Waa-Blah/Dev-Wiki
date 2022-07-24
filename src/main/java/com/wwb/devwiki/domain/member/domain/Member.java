package com.wwb.devwiki.domain.member.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", updatable = false)
    private Long id;

    private String realName;

    private String nickname;

    private String password;

    private String phoneNumber;

    private boolean accountActive;

    private Member(String realName, String nickname, String password, String phoneNumber, boolean accountActive) {
        this.realName = realName;
        this.nickname = nickname;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.accountActive = accountActive;
    }

    public static Member of(String realName, String nickname, String password, String phoneNumber, boolean accountActive) {
        return new Member(realName, nickname, password, phoneNumber, accountActive);
    }

}
