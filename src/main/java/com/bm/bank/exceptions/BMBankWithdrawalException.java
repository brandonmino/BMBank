package com.bm.bank.exceptions;

//General withdrawal exception
public class BMBankWithdrawalException extends BMBankException {

    public BMBankWithdrawalException(int code, String message) {
        super(code, message);
    }

}
