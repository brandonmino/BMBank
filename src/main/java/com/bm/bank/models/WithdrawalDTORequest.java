package com.bm.bank.models;

//Withdraw Model for making a request
public class WithdrawalDTORequest {
    int withdrawalAmount;

    public int getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(int newWithdrawalAmount) {
        withdrawalAmount = newWithdrawalAmount;
    }

}
