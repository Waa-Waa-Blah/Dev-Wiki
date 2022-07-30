package com.wwb.devwiki.domain.member.dto;

import com.wwb.devwiki.domain.member.domain.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberJoinReqDto {

    private String realName;

    private String nickname;

    private String password;

    private String phoneNumber;

    public Member toMember(){
        return Member.of(realName,nickname,password,phoneNumber,false);
    }


}
