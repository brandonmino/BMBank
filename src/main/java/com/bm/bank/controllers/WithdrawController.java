package com.bm.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.bm.bank.models.WithdrawDTORequest;
import com.bm.bank.services.WithdrawService;

//Withdraw controller object
@RestController
public class WithdrawController {
    @Autowired
    private WithdrawService withdrawService;

    //Attempt to make a withdraw from a given account. Returns code and message if succcessful or error if not.
    @PostMapping("/withdraw/{userId}")
    public ResponseEntity<Object> makeWithdraw(@PathVariable(required=true) Long userId, @RequestBody WithdrawDTORequest request) {
            return withdrawService.makeWithdraw(userId, request);
    }

}