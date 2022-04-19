package com.enigma.libraryapi.controller;

import com.enigma.libraryapi.constant.ResponseMessage;
import com.enigma.libraryapi.constant.UrlConstant;
import com.enigma.libraryapi.dto.BookSearchDTO;
import com.enigma.libraryapi.entity.Book;
import com.enigma.libraryapi.service.BookService;
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

import java.util.List;

@RestController
@RequestMapping(UrlConstant.BOOK)
public class BookController {
    @Autowired
    BookService bookService;

    //    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable String bookId) {
        return bookService.getBookById(bookId);
    }

    @PostMapping
    public ResponseEntity<Response<Book>> createBook(@RequestBody Book book) {
        Response<Book> response = new Response<>();
        String message = String.format(ResponseMessage.DATA_INSERTED, "book");
        response.setMessage(message);
        response.setData(bookService.createBook(book));
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @PutMapping
    public void updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
    }

    @DeleteMapping
    public void deleteBookById(@RequestParam String bookId) {
        bookService.deleteBookById(bookId);
    }

    @GetMapping
    public PageResponseWrapper<Book> getBookByPage(@RequestBody BookSearchDTO bookSearchDTO,
                                                   @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                   @RequestParam(name = "limit", defaultValue = "3") Integer limit,
                                                   @RequestParam(name = "sortBy", defaultValue = "title") String sortBy,
                                                   @RequestParam(name = "direct", defaultValue = "asc") String direct) {
        Sort sort = Sort.by(Sort.Direction.fromString(direct), sortBy);
        Pageable pageable = PageRequest.of(page, limit, sort);
        Page<Book> bookPage = bookService.getBookByPage(bookSearchDTO, pageable);
        return new PageResponseWrapper<>(bookPage);
    }

    //    @GetMapping
    public List<Book> getBookByTitle(@RequestParam String title) {
        return bookService.getBookByTitle(title);
    }
}
