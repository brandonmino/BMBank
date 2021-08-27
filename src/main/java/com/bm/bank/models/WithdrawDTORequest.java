package com.bm.bank.models;

//Withdraw Model for making a request
public class WithdrawDTORequest {
    int withdrawAmount;

    public int getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(int newWithdrawAmount) {
        withdrawAmount = newWithdrawAmount;
    }

}
