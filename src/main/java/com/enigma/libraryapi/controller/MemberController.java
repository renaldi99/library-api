package com.enigma.libraryapi.controller;

import com.enigma.libraryapi.constant.ResponseMessage;
import com.enigma.libraryapi.constant.UrlConstant;
import com.enigma.libraryapi.dto.MemberSearchDTO;
import com.enigma.libraryapi.entity.Member;
import com.enigma.libraryapi.service.MemberService;
import com.enigma.libraryapi.utils.PageResponseWrapper;
import com.enigma.libraryapi.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlConstant.MEMBER)
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping
    public ResponseEntity<Response<Member>> createMember(@RequestBody Member member) {
        Response<Member> response = new Response<>();
        String message = String.format(ResponseMessage.DATA_INSERTED, "member");
        response.setMessage(message);
        response.setData(memberService.createMember(member));
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(response);
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
    public PageResponseWrapper<Member> getMemberByPage(@RequestBody MemberSearchDTO memberSearchDTO,
                                                       @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                       @RequestParam(name = "limit", defaultValue = "3") Integer limit,
                                                       @RequestParam(name = "sortBy", defaultValue = "firstName") String sortBy,
                                                       @RequestParam(name = "direct", defaultValue = "asc") String direct) {
        Sort sort = Sort.by(Sort.Direction.fromString(direct), sortBy);
        Pageable pageable = PageRequest.of(page, limit, sort);
        Page<Member> memberPage = memberService.getMemberByPage(memberSearchDTO, pageable);
        return new PageResponseWrapper<>(memberPage);
    }
}
