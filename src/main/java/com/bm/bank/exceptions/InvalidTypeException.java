package com.bm.bank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.bm.bank.models.ExceptionResponseDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Global exception for invalid type provided in request
@ControllerAdvice
public class InvalidTypeException {
    private static final Logger logger = LoggerFactory.getLogger(InvalidTypeException.class);

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public ResponseEntity<ExceptionResponseDTO> handleTypeMismatchException(MethodArgumentTypeMismatchException typeMismatchException) {
        logger.warn("Invalid type provided in the request");
        ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO(5000, "Invalid type provided in the request");
        return new ResponseEntity<ExceptionResponseDTO>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
