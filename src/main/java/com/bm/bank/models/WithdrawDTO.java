package com.bm.bank.models;

//Withdraw Model
public class WithdrawDTO {
    String message;

    public WithdrawDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}