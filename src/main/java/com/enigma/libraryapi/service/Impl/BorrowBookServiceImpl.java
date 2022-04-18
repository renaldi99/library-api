package com.enigma.libraryapi.service.Impl;

import com.enigma.libraryapi.entity.Book;
import com.enigma.libraryapi.entity.BorrowBook;
import com.enigma.libraryapi.entity.Member;
import com.enigma.libraryapi.repository.BookRepository;
import com.enigma.libraryapi.repository.BorrowBookRepository;
import com.enigma.libraryapi.repository.MemberRepository;
import com.enigma.libraryapi.service.BookService;
import com.enigma.libraryapi.service.BorrowBookService;
import com.enigma.libraryapi.service.MemberService;
import com.enigma.libraryapi.utils.AddDayJodaTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;

@Service
public class BorrowBookServiceImpl implements BorrowBookService {
    @Autowired
    BorrowBookRepository borrowBookRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public BorrowBook saveBorrowBook(BorrowBook borrowBook) {
        Member member = memberRepository.findById(borrowBook.getMember().getId()).get();
        Book book = bookRepository.findById(borrowBook.getBook().getId()).get();

        if (book.getStock() > 0) {
            book.setStock(book.getStock() - 1);
            borrowBook.setMember(member);
            borrowBook.setBook(book);
            borrowBook.setStatus("Active");
            return borrowBookRepository.save(borrowBook);
        }
        return null;
    }

    @Override
    public BorrowBook getBorrowBookById(String borrowBookId) {
        return borrowBookRepository.findById(borrowBookId).get();
    }

    @Override
    public BorrowBook updateBorrowBook(BorrowBook borrowBook) {
        Member member = memberRepository.findById(borrowBook.getMember().getId()).get();
        Book book = bookRepository.findById(borrowBook.getBook().getId()).get();
        BorrowBook borrowBookAttr = borrowBookRepository.findById(borrowBook.getId()).get();
        LocalDateTime dateTimeBorrowed = borrowBookAttr.getBorrowedDate();
        LocalDateTime dateTimeReturn = borrowBookAttr.getReturnDate();
        String getStatus = borrowBookAttr.getStatus();

        borrowBook.setMember(member);
        borrowBook.setBook(book);
        borrowBook.setBorrowedDate(dateTimeBorrowed);
        borrowBook.setReturnDate(dateTimeReturn);
        borrowBook.setStatus(getStatus);
        return borrowBookRepository.save(borrowBook);
    }

    @Override
    public void deleteBorrowBook(String borrowBookId) {
        borrowBookRepository.deleteById(borrowBookId);
    }
}
