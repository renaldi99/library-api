package com.enigma.libraryapi.exception;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
public class StockNotEnoughException extends ServiceException {
    public StockNotEnoughException(String message) {
        super(message);
    }
}
