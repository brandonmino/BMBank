package com.bm.bank.exceptions;

//General deposit exception
public class BMBankDepositException extends BMBankException {

    public BMBankDepositException(int code, String message) {
        super(code, message);
    }

}
