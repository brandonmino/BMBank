package com.bm.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.bm.bank.models.Withdraw;
import com.bm.bank.services.WithdrawService;

//Withdraw controller object
@RestController
public class WithdrawController {
    @Autowired
    private WithdrawService withdrawService;

    //Attempt to withdraw from given account
    @PostMapping("/withdraw/{userId}")
    public EntityModel<Withdraw> makeWithdraw(@PathVariable(required=true) Long userId, @RequestBody Withdraw withdrawDetails) {
        Withdraw newWithdraw = withdrawService.makeWithdraw(userId, withdrawDetails.getWithdrawAmount());
        return EntityModel.of(newWithdraw,
                linkTo(methodOn(WithdrawController.class).makeWithdraw(userId, withdrawDetails)).withSelfRel()
        );   
    }

}