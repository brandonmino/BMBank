package com.bm.bank.exceptions;

//Exception for trying to withdrawal more funds than you have
public class ExcessiveWithdrawalException extends BMBankWithdrawalException {
    public ExcessiveWithdrawalException() {
        super(3001, "Withdrawalal was blocked as you attempted to withdrawal more than your current balance");
    }

    public ExcessiveWithdrawalException(int code, String message) {
        super(code, message);
    }
}
