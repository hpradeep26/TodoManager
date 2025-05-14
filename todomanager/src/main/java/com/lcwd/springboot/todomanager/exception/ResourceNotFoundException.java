package com.lcwd.springboot.todomanager.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException{

    private String message;
    private HttpStatus httpStatus;

    public ResourceNotFoundException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public ResourceNotFoundException() {
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
