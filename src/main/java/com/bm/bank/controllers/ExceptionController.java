package com.bm.bank.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bm.bank.exceptions.BMBankException;
import com.bm.bank.models.ExceptionResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
@RestController
public class ExceptionController extends ResponseEntityExceptionHandler {
    final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(BMBankException.class)
    public final ResponseEntity<ExceptionResponse> handleAllBadRequestExceptions(BMBankException err, WebRequest request) {
        logger.warn("code: " + err.getErrorCode() + " message: " + err.getErrorMessage());
        ExceptionResponse exceptionResponse = new ExceptionResponse(err.getErrorCode(), err.getErrorMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    // @ExceptionHandler(ExcessiveWithdrawException.class)
    // public final ResponseEntity<BMBankException> handleNegativeDepositException(NegativeDepositException err, WebRequest request) {
    //     logger.warn("Error code: " + err.getErrorCode() + " message: " + err.getErrorMessage());
    //     BMBankException exceptionResponse = new BMBankException(err.getErrorCode(), err.getErrorMessage());
    //     return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    // }

    // @ExceptionHandler(UserIdNotProvidedException.class)
    // public final ResponseEntity<BMBankException> handleUserIdNotProvided(UserIdNotProvidedException err, WebRequest request) {
    //     logger.warn("Error code: " + err.getErrorCode() + " message: " + err.getErrorMessage());
    //     BMBankException exceptionResponse = new BMBankException(err.getErrorCode(), err.getErrorMessage());
    //     return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    // }

    // @ExceptionHandler(UserNotFoundException.class)
    // public final ResponseEntity<BMBankException> handleUserNotFoundException(UserNotFoundException err, WebRequest request) {
    //     logger.warn("Error code: " + err.getErrorCode() + " message: " + err.getErrorMessage());
    //     BMBankException exceptionResponse = new BMBankException(err.getErrorCode(), err.getErrorMessage());
    //     return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    // }

    // @ExceptionHandler(UserNotProvidedException.class)
    // public final ResponseEntity<BMBankException> handleUserNotProvidedException(UserNotProvidedException err, WebRequest request) {
    //     logger.warn("Error code: " + err.getErrorCode() + " message: " + err.getErrorMessage());
    //     BMBankException exceptionResponse = new BMBankException(err.getErrorCode(), err.getErrorMessage());
    //     return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    // }
}
