package com.bm.bank.models;

public class ExceptionResponse {
    private int error;
    private String message;
    
    public ExceptionResponse(int code, String errorMessage) {
        this.error = code;
        this.message = errorMessage;
    }

    public int getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
