package com.bm.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bm.bank.exceptions.NegativeDepositException;
import com.bm.bank.exceptions.UserIdNotProvidedException;
import com.bm.bank.exceptions.UserNotFoundException;
import com.bm.bank.exceptions.UserNotProvidedException;
import com.bm.bank.models.Deposit;
import com.bm.bank.services.DepositService;

//Deposit controller object
@RestController
public class DepositController {
    @Autowired
    private DepositService depositService;
    private static final Logger logger = LoggerFactory.getLogger(DepositController.class);

    //Attempt to deposit to given account
    @PostMapping("/deposit/{userId}")
    public ResponseEntity<Object> makeDeposit(@PathVariable(required=true) Long userId, @RequestBody Deposit depositDetails) {
        try {
            Deposit newDeposit = depositService.makeDeposit(userId, depositDetails.getDepositAmount());
            URI uri = linkTo(methodOn(DepositController.class).makeDeposit(userId, depositDetails)).withSelfRel().toUri();
            return ResponseEntity.created(uri).body(newDeposit);
        }
        catch (UserNotFoundException ex) {
            logger.warn("HTTP Status: " + HttpStatus.METHOD_NOT_ALLOWED.toString());
            logger.warn(ex.toString());
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        }   
        catch (UserIdNotProvidedException | UserNotProvidedException | NegativeDepositException ex) {
            logger.warn("HTTP Status: " + HttpStatus.BAD_REQUEST.toString());
            logger.warn(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
