package com.lcwd.springboot.todomanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResoureNotFoundException(ResourceNotFoundException ex){
        ErrorResponse response = new ErrorResponse(ex.getMessage(),ex.getHttpStatus());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

}
