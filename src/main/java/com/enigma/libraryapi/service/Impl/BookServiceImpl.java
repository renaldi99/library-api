package com.enigma.libraryapi.service.Impl;

import com.enigma.libraryapi.constant.ResponseMessage;
import com.enigma.libraryapi.dto.BookSearchDTO;
import com.enigma.libraryapi.entity.Book;
import com.enigma.libraryapi.exception.DataNotFoundException;
import com.enigma.libraryapi.repository.BookRepository;
import com.enigma.libraryapi.service.BookService;
import com.enigma.libraryapi.specifcation.BookSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(String bookId) {
        if (!bookRepository.findById(bookId).isPresent()) {
            String message = String.format(ResponseMessage.DATA_NOT_FOUND, "book", bookId);
            throw new DataNotFoundException(message);
        }
        return bookRepository.findById(bookId).get();
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBookById(String bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Page<Book> getBookByPage(BookSearchDTO bookSearchDTO, Pageable pageable) {
        Specification<Book> bookSpecification = BookSpecification.getSpecification(bookSearchDTO);
        return bookRepository.findAll(bookSpecification, pageable);
    }

    @Override
    public List<Book> getBookByTitle(String title) {
        return bookRepository.findBookByTitleContainingIgnoreCase(title);
    }
}
