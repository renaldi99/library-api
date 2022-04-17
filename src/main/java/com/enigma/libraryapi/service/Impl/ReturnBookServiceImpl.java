package com.enigma.libraryapi.service.Impl;

import com.enigma.libraryapi.entity.BorrowBook;
import com.enigma.libraryapi.entity.ReturnBook;
import com.enigma.libraryapi.repository.BorrowBookRepository;
import com.enigma.libraryapi.repository.ReturnBookRepository;
import com.enigma.libraryapi.service.BorrowBookService;
import com.enigma.libraryapi.service.ReturnBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ReturnBookServiceImpl implements ReturnBookService {
    @Autowired
    ReturnBookRepository returnBookRepository;

    @Autowired
    BorrowBookRepository borrowBookRepository;

    @Override
    public ReturnBook createReturnBook(ReturnBook returnBook) {
        BorrowBook borrowBook = borrowBookRepository.findById(returnBook.getBorrowBook().getId()).get();

        borrowBook.setStatus("Inactive");
        borrowBook.getBook().setStock(borrowBook.getBook().getStock() + 1);
        returnBook.setCharge(10000);

        return returnBookRepository.save(returnBook);
    }
}
