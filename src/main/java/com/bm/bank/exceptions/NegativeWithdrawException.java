package com.bm.bank.exceptions;

//Exception for trying to withdraw more funds than you have
public class NegativeWithdrawException extends BMBankDepositException {
    public NegativeWithdrawException() {
        super(2000, "Withdraw was blocked as you attempted to withdraw a negative amount");
    }

    public NegativeWithdrawException(int code, String message) {
        super(code, message);
    }
}