package com.bm.bank.models;

//Withdraw Model for making a request
public class WithdrawDTORequest {
    int withdrawAmount;

    public WithdrawDTORequest(int withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public int getWithdrawAmount() {
        return withdrawAmount;
    }

}
