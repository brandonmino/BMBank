package com.bm.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.bm.bank.models.WithdrawalDTORequest;
import com.bm.bank.services.WithdrawalService;

//Withdrawalal controller object
@RestController
public class WithdrawalController {
    @Autowired
    private WithdrawalService withdrawService;

    //Attempt to make a withdrawal from a given account. Returns code and message if succcessful or error if not.
    @PostMapping("/withdrawal/{userId}")
    public ResponseEntity<Object> makeWithdrawal(@PathVariable(required=true) Long userId, @RequestBody WithdrawalDTORequest request) {
            return withdrawService.makeWithdrawal(userId, request);
    }

}