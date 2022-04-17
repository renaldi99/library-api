package com.enigma.libraryapi.controller;

import com.enigma.libraryapi.constant.UrlConstant;
import com.enigma.libraryapi.entity.BorrowBook;
import com.enigma.libraryapi.service.BorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlConstant.BORROW)
public class BorrowBookController {
    @Autowired
    BorrowBookService borrowBookService;

    @GetMapping("/{borrowBookId}")
    public BorrowBook getBorrowBookById(@PathVariable String borrowBookId) {
        return borrowBookService.getBorrowBookById(borrowBookId);
    }

    @PostMapping
    public BorrowBook saveBorrowBook(@RequestBody BorrowBook borrowBook) {
        return borrowBookService.saveBorrowBook(borrowBook);
    }

    @PutMapping
    public BorrowBook updateBorrowBook(@RequestBody BorrowBook borrowBook) {
        return borrowBookService.updateBorrowBook(borrowBook);
    }

    @DeleteMapping
    public void deleteBorrowBookById(@RequestParam String borrowBookId) {
        borrowBookService.deleteBorrowBook(borrowBookId);
    }
}
