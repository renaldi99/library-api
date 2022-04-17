package com.enigma.libraryapi.repository;

import com.enigma.libraryapi.entity.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowBookRepository extends JpaRepository<BorrowBook, String> {
}
