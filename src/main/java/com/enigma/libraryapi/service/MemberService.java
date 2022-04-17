package com.enigma.libraryapi.service;

import com.enigma.libraryapi.dto.MemberSearchDTO;
import com.enigma.libraryapi.entity.Member;
import com.enigma.libraryapi.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface MemberService {
    public Member createMember(Member member);
    public void updateMember(Member member);
    public void deleteMember(String memberId);
    public Member getMemberById(String memberId);
    public Page<Member> getMemberByPage(MemberSearchDTO memberSearchDTO, Pageable pageable);
}
