package com.wwb.devwiki.domain.member.repository;

import com.wwb.devwiki.domain.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
