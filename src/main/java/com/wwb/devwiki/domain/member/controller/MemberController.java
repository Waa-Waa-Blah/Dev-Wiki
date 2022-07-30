package com.wwb.devwiki.domain.member.controller;

import com.wwb.devwiki.domain.member.domain.Member;
import com.wwb.devwiki.domain.member.dto.MemberJoinReqDto;
import com.wwb.devwiki.domain.member.dto.MemberLoginReqDto;
import com.wwb.devwiki.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RequestMapping("/api/member")
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public void join(@RequestBody MemberJoinReqDto memberJoinReqDto) {
        memberService.join(memberJoinReqDto);
    }

    @PostMapping("/login")
    public void login(MemberLoginReqDto memberLoginReqDto, HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        Member member = memberService.login(memberLoginReqDto.nickname, memberLoginReqDto.password);
        session.setAttribute("loginUser", member.getId());
    }

}
