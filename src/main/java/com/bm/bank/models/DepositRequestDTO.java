package com.bm.bank.models;

//Deposit Model
public class DepositRequestDTO {
    private String message;

    public DepositRequestDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
