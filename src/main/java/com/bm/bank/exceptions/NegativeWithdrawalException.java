package com.bm.bank.exceptions;

//Exception for trying to withdraw more funds than you have
public class NegativeWithdrawalException extends BMBankDepositException {
    public NegativeWithdrawalException() {
        super(3001, "Withdraw was blocked as you attempted to withdraw a negative amount");
    }

    public NegativeWithdrawalException(int code, String message) {
        super(code, message);
    }
}