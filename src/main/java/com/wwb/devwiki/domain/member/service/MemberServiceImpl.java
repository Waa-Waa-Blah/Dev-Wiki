package com.wwb.devwiki.domain.member.service;

import com.wwb.devwiki.domain.member.domain.Member;
import com.wwb.devwiki.domain.member.dto.MemberJoinReqDto;
import com.wwb.devwiki.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member join(MemberJoinReqDto memberJoinReqDto) {
        Member member = memberJoinReqDto.toMember();
        return memberRepository.save(member);
    }

    @Override
    public Member login(String id, String password) {
        return memberRepository.findByNicknameAndPassword(id, password);
    }

    @Override
    public Member findMemberById(Long loginUserId) {
        return memberRepository.findById(loginUserId).get();
    }
}
