package com.bm.bank.exceptions;

public class BMBankException extends RuntimeException {
    private int errorCode;
    private String errorMessage;

    public BMBankException() {}

    public BMBankException(int code, String message) {
        this.errorCode = code;
        this.errorMessage = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorCode(int code) {
        errorCode = code;
    }

    public void setErrorMessage(String message) {
        errorMessage = message;
    }
}
