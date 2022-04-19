package com.enigma.libraryapi.service;

import com.enigma.libraryapi.entity.ReturnBook;

public interface ReturnBookService {
    public ReturnBook createReturnBook(ReturnBook returnBook);
    public ReturnBook getReturnBookById(String returnBook);
}
