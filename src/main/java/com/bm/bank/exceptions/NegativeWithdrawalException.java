package com.bm.bank.exceptions;

//Exception for trying to withdraw more funds than you have
public class NegativeWithdrawalException extends BMBankDepositException {
    public NegativeWithdrawalException() {
        super(3000, "Withdrawal was blocked as you attempted to withdraw a negative amount");
    }

    public NegativeWithdrawalException(int code, String message) {
        super(code, message);
    }
}