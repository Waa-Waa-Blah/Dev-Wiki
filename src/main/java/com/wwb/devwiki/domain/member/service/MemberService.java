package com.wwb.devwiki.domain.member.service;

import com.wwb.devwiki.domain.member.domain.Member;
import com.wwb.devwiki.domain.member.dto.MemberJoinReqDto;

public interface MemberService {

    Member join(MemberJoinReqDto memberJoinReqDto);

    Member login(String id, String password);

    Member findMemberById(Long loginUserId);
}
