package com.bm.bank.exceptions;

public class ExcessiveWithdrawException extends RuntimeException{
    public ExcessiveWithdrawException() {
        super("Withdraw was blocked as you attempted to withdraw more than your current balance");
    }
}
