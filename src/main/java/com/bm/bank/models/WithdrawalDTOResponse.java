package com.bm.bank.models;

//Withdrawalal Model for handling a response
public class WithdrawalDTOResponse {
    String message;

    public WithdrawalDTOResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
