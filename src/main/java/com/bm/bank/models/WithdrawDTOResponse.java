package com.bm.bank.models;

//Withdraw Model for handling a response
public class WithdrawDTOResponse {
    String message;

    public WithdrawDTOResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
