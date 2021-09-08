package com.bm.bank.exceptions;

//Exception for trying to withdraw more funds than you have
public class ExcessiveWithdrawalException extends BMBankWithdrawalException {
    public ExcessiveWithdrawalException() {
        super(3001, "Withdrawal was blocked as you attempted to withdraw more than your current balance");
    }

    public ExcessiveWithdrawalException(int code, String message) {
        super(code, message);
    }
}
