package com.bm.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.bm.bank.models.Deposit;
import com.bm.bank.services.DepositService;

//import java.util.Map;

//Deposit controller object
@RestController
public class DepositController {
    @Autowired
    private DepositService depositService;

    //Get the existing account
    @PostMapping("/deposit/{userId}")
    public EntityModel<Deposit> makeDeposit(@PathVariable(required=true) Long userId, @RequestBody Deposit depositDetails) {
        Deposit newDeposit = depositService.makeDeposit(userId, depositDetails.getAmount());
        return EntityModel.of(newDeposit,
                linkTo(methodOn(DepositController.class).makeDeposit(userId, depositDetails)).withSelfRel()
        );   
    }

}
