package com.bm.bank.exceptions;

//General withdraw exception
public class BMBankWithdrawalException extends BMBankException {

    public BMBankWithdrawalException(int code, String message) {
        super(code, message);
    }

}
