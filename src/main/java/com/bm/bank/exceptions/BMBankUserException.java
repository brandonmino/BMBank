package com.bm.bank.exceptions;

//General user exception
public class BMBankUserException extends BMBankException {

    public BMBankUserException(int code, String message) {
        super(code, message);
    }

}
