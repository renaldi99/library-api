package com.enigma.libraryapi.controller;

import com.enigma.libraryapi.constant.UrlConstant;
import com.enigma.libraryapi.entity.ReturnBook;
import com.enigma.libraryapi.service.ReturnBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlConstant.RETURN)
public class ReturnBookController {
    @Autowired
    ReturnBookService returnBookService;

    @PostMapping
    public ReturnBook createReturnBook(@RequestBody ReturnBook returnBook) {
        return returnBookService.createReturnBook(returnBook);
    }
}
