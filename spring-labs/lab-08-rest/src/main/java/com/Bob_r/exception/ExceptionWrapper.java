package com.Bob_r.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ExceptionWrapper {
    public String message;
    public HttpStatus httpStatus;

    public ExceptionWrapper(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
