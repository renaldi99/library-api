package com.enigma.libraryapi.service;

import com.enigma.libraryapi.dto.BookSearchDTO;
import com.enigma.libraryapi.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();
    public Book getBookById(String bookId);
    public Book createBook(Book book);
    public void updateBook(Book book);
    public void deleteBookById(String bookId);
    public Page<Book> getBookByPage(BookSearchDTO bookSearchDTO, Pageable pageable);
    public List<Book> getBookByTitle(String title);
}
