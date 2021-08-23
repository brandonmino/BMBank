package com.bm.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.bm.bank.exceptions.ExcessiveWithdrawException;
import com.bm.bank.exceptions.UserIdNotProvidedException;
import com.bm.bank.exceptions.UserNotFoundException;
import com.bm.bank.exceptions.UserNotProvidedException;
import com.bm.bank.models.Withdraw;
import com.bm.bank.services.WithdrawService;

//Withdraw controller object
@RestController
public class WithdrawController {
    @Autowired
    private WithdrawService withdrawService;
    private static final Logger logger = LoggerFactory.getLogger(WithdrawController.class);

    //Attempt to withdraw from given account
    @PostMapping("/withdraw/{userId}")
    public ResponseEntity<Object> makeWithdraw(@PathVariable(required=true) Long userId, @RequestBody Withdraw withdrawDetails) {
        try {
            Withdraw newWithdraw = withdrawService.makeWithdraw(userId, withdrawDetails.getWithdrawAmount());
            URI uri = linkTo(methodOn(WithdrawController.class).makeWithdraw(userId, withdrawDetails)).withSelfRel().toUri();
            return ResponseEntity.created(uri).body(newWithdraw);
        }
        catch (UserNotFoundException ex) {
            logger.warn("HTTP Status: " + HttpStatus.METHOD_NOT_ALLOWED.toString());
            logger.warn(ex.toString());
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        }   
        catch (UserIdNotProvidedException | UserNotProvidedException | ExcessiveWithdrawException ex) {
            logger.warn("HTTP Status: " + HttpStatus.BAD_REQUEST.toString());
            logger.warn(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}