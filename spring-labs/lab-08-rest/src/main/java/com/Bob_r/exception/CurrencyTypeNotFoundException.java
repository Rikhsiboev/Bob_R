package com.Bob_r.exception;

public class CurrencyTypeNotFoundException extends RuntimeException {
    public CurrencyTypeNotFoundException(String messages) {
        super(messages);
    }
}
