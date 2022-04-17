package com.enigma.libraryapi.controller;

import com.enigma.libraryapi.constant.UrlConstant;
import com.enigma.libraryapi.dto.MemberSearchDTO;
import com.enigma.libraryapi.entity.Member;
import com.enigma.libraryapi.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlConstant.MEMBER)
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    @PutMapping
    public void updateMember(@RequestBody Member member) {
        memberService.updateMember(member);
    }

    @DeleteMapping
    public void deleteMember(@RequestParam String memberId) {
        memberService.deleteMember(memberId);
    }

    @GetMapping("/{memberId}")
    public Member getMemberById(@PathVariable String memberId) {
        return memberService.getMemberById(memberId);
    }

    @GetMapping
    public Page<Member> getMemberByPage(@RequestBody MemberSearchDTO memberSearchDTO,
                                        @RequestParam(name = "page", defaultValue = "0") Integer page,
                                        @RequestParam(name = "limit", defaultValue = "3") Integer limit,
                                        @RequestParam(name = "sortBy", defaultValue = "firstName") String sortBy,
                                        @RequestParam(name = "direct", defaultValue = "asc") String direct) {
        Sort sort = Sort.by(Sort.Direction.fromString(direct), sortBy);
        Pageable pageable = PageRequest.of(page, limit, sort);
        return memberService.getMemberByPage(memberSearchDTO, pageable);
    }
}
