package com.enigma.libraryapi.repository;

import com.enigma.libraryapi.entity.ReturnBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnBookRepository extends JpaRepository<ReturnBook, String> {
}
