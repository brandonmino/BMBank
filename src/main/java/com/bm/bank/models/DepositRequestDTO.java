package com.bm.bank.models;

//Deposit Model for making a request
public class DepositRequestDTO {
    private int depositAmount;

    public DepositRequestDTO(int depositAmount) {
        this.depositAmount = depositAmount;
    }

    public int getDepositAmount() {
        return depositAmount;
    }
}
