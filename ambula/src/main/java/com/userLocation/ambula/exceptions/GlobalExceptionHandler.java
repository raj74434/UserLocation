package com.userLocation.ambula.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

//This is a global exception handler which help in manager all rest api exception at one place.

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> exceptionClassHandler(Exception exp, WebRequest req){

        ErrorDetails err = new ErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));



        return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorDetails> userExceptionClassHandler(Exception exp, WebRequest req){

        ErrorDetails err = new ErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));



        return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }

}
