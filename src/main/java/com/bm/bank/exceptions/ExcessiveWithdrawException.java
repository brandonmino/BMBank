package com.bm.bank.exceptions;

//Exception for trying to withdraw more funds than you have
public class ExcessiveWithdrawException extends BMBankWithdrawException {
    public ExcessiveWithdrawException() {
        super(3000, "Withdraw was blocked as you attempted to withdraw more than your current balance");
    }

    public ExcessiveWithdrawException(int code, String message) {
        super(code, message);
    }
}
