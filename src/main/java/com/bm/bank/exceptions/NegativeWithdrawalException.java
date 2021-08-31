package com.bm.bank.exceptions;

//Exception for trying to withdrawal more funds than you have
public class NegativeWithdrawalException extends BMBankDepositException {
    public NegativeWithdrawalException() {
        super(3000, "Withdrawalal was blocked as you attempted to withdrawal a negative amount");
    }

    public NegativeWithdrawalException(int code, String message) {
        super(code, message);
    }
}