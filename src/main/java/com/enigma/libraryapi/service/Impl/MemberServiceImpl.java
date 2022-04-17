package com.enigma.libraryapi.service.Impl;

import com.enigma.libraryapi.dto.MemberSearchDTO;
import com.enigma.libraryapi.entity.Member;
import com.enigma.libraryapi.repository.MemberRepository;
import com.enigma.libraryapi.service.MemberService;
import com.enigma.libraryapi.specifcation.MemberSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void updateMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void deleteMember(String memberId) {
        memberRepository.deleteById(memberId);
    }

    @Override
    public Member getMemberById(String memberId) {
        return memberRepository.findById(memberId).get();
    }

    @Override
    public Page<Member> getMemberByPage(MemberSearchDTO memberSearchDTO, Pageable pageable) {
        Specification<Member> memberSpecification = MemberSpecification.getSpecification(memberSearchDTO);
        return memberRepository.findAll(memberSpecification, pageable);
    }
}
