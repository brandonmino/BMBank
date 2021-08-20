package com.bm.bank.exceptions;

//Exception for trying to withdraw more funds than you have
public class NegativeDepositException extends RuntimeException{
    public NegativeDepositException() {
        super("Deposit was blocked as you attempted to deposit a negative amount");
    }
}