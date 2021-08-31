package com.bm.bank.models;

//Withdrawalal Model for making a request
public class WithdrawalDTORequest {
    int withdrawAmount;

    public int getWithdrawalAmount() {
        return withdrawAmount;
    }

    public void setWithdrawalAmount(int newWithdrawalAmount) {
        withdrawAmount = newWithdrawalAmount;
    }

}
