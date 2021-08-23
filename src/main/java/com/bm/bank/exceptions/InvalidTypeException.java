package com.bm.bank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Global exception for invalid type provided in request
@ControllerAdvice
public class InvalidTypeException {
    private static final Logger logger = LoggerFactory.getLogger(InvalidTypeException.class);

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public ResponseEntity<Object> handleTypeMismatchException(MethodArgumentTypeMismatchException typeMismatchException) {
        logger.info("HTTP Status: " + HttpStatus.BAD_REQUEST.toString());
        logger.info("Invalid type provided in the request");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
