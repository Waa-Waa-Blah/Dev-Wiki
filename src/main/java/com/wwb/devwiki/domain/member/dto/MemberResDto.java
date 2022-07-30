package com.wwb.devwiki.domain.member.dto;

import com.wwb.devwiki.domain.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberResDto {

    private String nickname;

    public static MemberResDto toMember(Member author) {
        return new MemberResDto(author.getNickname());
    }
}
