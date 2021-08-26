package com.bm.bank.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bm.bank.exceptions.BMBankException;
import com.bm.bank.models.ExceptionResponseDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
@RestController
public class ExceptionController extends ResponseEntityExceptionHandler {
    final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(BMBankException.class)
    public final ResponseEntity<ExceptionResponseDTO> handleAllBadRequestExceptions(BMBankException err, WebRequest request) {
        logger.warn("code: " + err.getErrorCode() + " message: " + err.getErrorMessage());
        ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO(err.getErrorCode(), err.getErrorMessage());
        return new ResponseEntity<ExceptionResponseDTO>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
