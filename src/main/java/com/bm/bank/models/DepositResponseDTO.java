package com.bm.bank.models;

//Deposit Model for handling a response
public class DepositResponseDTO {
    private String message;

    public DepositResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
