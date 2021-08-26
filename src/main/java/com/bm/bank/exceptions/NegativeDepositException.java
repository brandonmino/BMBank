package com.bm.bank.exceptions;

//Exception for trying to withdraw more funds than you have
public class NegativeDepositException extends BMBankDepositException {
    public NegativeDepositException() {
        super(2000, "Deposit was blocked as you attempted to deposit a negative amount");
    }

    public NegativeDepositException(int code, String message) {
        super(code, message);
    }
}