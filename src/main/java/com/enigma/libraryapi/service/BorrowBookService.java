package com.enigma.libraryapi.service;

import com.enigma.libraryapi.entity.BorrowBook;

public interface BorrowBookService {
    public BorrowBook saveBorrowBook(BorrowBook borrowBook);
    public BorrowBook updateBorrowBook(BorrowBook borrowBook);
    public BorrowBook getBorrowBookById(String borrowBookId);
    public void deleteBorrowBook(String borrowBookId);
}
