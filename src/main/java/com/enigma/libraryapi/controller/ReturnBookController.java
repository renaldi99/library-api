package com.enigma.libraryapi.controller;

import com.enigma.libraryapi.constant.UrlConstant;
import com.enigma.libraryapi.entity.ReturnBook;
import com.enigma.libraryapi.service.ReturnBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlConstant.RETURN)
public class ReturnBookController {
    @Autowired
    ReturnBookService returnBookService;

    @GetMapping("/{returnBookId}")
    public ReturnBook getReturnBookById(@PathVariable String returnBookId) {
        return returnBookService.getReturnBookById(returnBookId);
    }

    @PostMapping
    public ReturnBook createReturnBook(@RequestBody ReturnBook returnBook) {
        return returnBookService.createReturnBook(returnBook);
    }
}
