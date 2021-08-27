package com.bm.bank.models;

//Deposit Model for making a request
public class DepositRequestDTO {
    private int depositAmount;

    public int getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(int newDepositAmount) {
        depositAmount = newDepositAmount;
    }
}
