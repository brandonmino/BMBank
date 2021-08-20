package com.bm.bank.exceptions;

//Exception for trying to withdraw more funds than you have
public class ExcessiveWithdrawException extends RuntimeException{
    public ExcessiveWithdrawException() {
        super("Withdraw was blocked as you attempted to withdraw more than your current balance");
    }
}
