package com.moovia.rickymicroservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.moovia.rickymicroservice.util.ResponseInfo;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException ex) {
        ResponseInfo responseInfo = new ResponseInfo("Error", ex.getStatusCode());
        return ResponseEntity.status(ex.getStatusCode()).body(responseInfo);
    }
}
