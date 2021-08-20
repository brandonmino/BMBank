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
    private static final Logger logger = LoggerFactory.getLogger(DepositController.class);

    //Attempt to withdraw from given account
    @PostMapping("/withdraw/{userId}")
    public ResponseEntity<String> makeWithdraw(@PathVariable(required=true) Long userId, @RequestBody Withdraw withdrawDetails) {
        try {
            logger.info("Attempting to make withdraw with the following info: userID: " + userId + " withdrawAmount: " + withdrawDetails.getWithdrawAmount());
            Withdraw newWithdraw = withdrawService.makeWithdraw(userId, withdrawDetails.getWithdrawAmount());
            EntityModel<Withdraw> entity = EntityModel.of(newWithdraw, linkTo(methodOn(WithdrawController.class).makeWithdraw(userId, withdrawDetails)).withSelfRel());
            logger.info("HTTP Status: " + HttpStatus.CREATED.toString());
            logger.info(entity.toString());
            return new ResponseEntity<String>(entity.toString(), HttpStatus.CREATED); 
            // return EntityModel.of(newWithdraw,
            //         linkTo(methodOn(WithdrawController.class).makeWithdraw(userId, withdrawDetails)).withSelfRel()
            // );
        }
        catch (UserNotFoundException ex) {
            logger.info("HTTP Status: " + HttpStatus.METHOD_NOT_ALLOWED.toString());
            logger.info(ex.toString());
            return new ResponseEntity<String>(ex.toString(), HttpStatus.METHOD_NOT_ALLOWED);
        }   
        catch (UserIdNotProvidedException | UserNotProvidedException | ExcessiveWithdrawException ex) {
            logger.info("HTTP Status: " + HttpStatus.BAD_REQUEST.toString());
            logger.info(ex.toString());
            return new ResponseEntity<String>(ex.toString(), HttpStatus.BAD_REQUEST);
        }
    }

}