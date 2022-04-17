package com.enigma.libraryapi.repository;

import com.enigma.libraryapi.entity.Book;
import com.enigma.libraryapi.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    public Page<Member> findAll(Specification<Member> specification, Pageable pageable);
}
