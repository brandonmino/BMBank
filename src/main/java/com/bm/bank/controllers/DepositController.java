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
    public ResponseEntity<String> makeDeposit(@PathVariable(required=true) Long userId, @RequestBody Deposit depositDetails) {
        try {
            logger.info("Attempting to make deposit with the following info: userID: " + userId + " depositAmount: " + depositDetails.getDepositAmount());
            Deposit newDeposit = depositService.makeDeposit(userId, depositDetails.getDepositAmount());
            EntityModel<Deposit> entity = EntityModel.of(newDeposit, linkTo(methodOn(DepositController.class).makeDeposit(userId, depositDetails)).withSelfRel());
            logger.info("HTTP Status: " + HttpStatus.CREATED.toString());
            logger.info(entity.toString());
            return new ResponseEntity<String>(entity.toString(), HttpStatus.CREATED); 
            // return EntityModel.of(newDeposit,
            //         linkTo(methodOn(DepositController.class).makeDeposit(userId, depositDetails)).withSelfRel()
            // );
        }
        catch (UserNotFoundException ex) {
            logger.info("HTTP Status: " + HttpStatus.METHOD_NOT_ALLOWED.toString());
            logger.info(ex.toString());
            return new ResponseEntity<String>(ex.toString(), HttpStatus.METHOD_NOT_ALLOWED);
        }   
        catch (UserIdNotProvidedException | UserNotProvidedException | NegativeDepositException ex) {
            logger.info("HTTP Status: " + HttpStatus.BAD_REQUEST.toString());
            logger.info(ex.toString());
            return new ResponseEntity<String>(ex.toString(), HttpStatus.BAD_REQUEST);
        }
    }

}
