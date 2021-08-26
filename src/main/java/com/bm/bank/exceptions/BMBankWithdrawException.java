package com.bm.bank.exceptions;

//General withdraw exception
public class BMBankWithdrawException extends BMBankException {

    public BMBankWithdrawException(int code, String message) {
        super(code, message);
    }

}
