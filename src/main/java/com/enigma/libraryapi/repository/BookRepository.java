package com.enigma.libraryapi.repository;

import com.enigma.libraryapi.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    public Page<Book> findAll(Specification<Book> specification, Pageable pageable);
    public List<Book>findBookByTitleContainingIgnoreCase(@Param("title") String title);
}
