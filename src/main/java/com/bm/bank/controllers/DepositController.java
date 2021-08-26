package com.bm.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.bm.bank.models.Deposit;
import com.bm.bank.services.DepositService;

//Deposit controller object
@RestController
public class DepositController {
    @Autowired
    private DepositService depositService;

    //Attempt to make a deposit to a given account. Returns code and message if succcessful or error if not.
    @PostMapping("/deposit/{userId}")
    public ResponseEntity<Object> makeDeposit(@PathVariable(required=true) Long userId, @RequestBody Deposit depositDetails) {
        return depositService.makeDeposit(userId, depositDetails.getDepositAmount());
    }

}
