package com.bm.bank.models;

//Exception Model for handling a response
public class ExceptionResponseDTO {
    private int error;
    private String message;
    
    public ExceptionResponseDTO(int code, String errorMessage) {
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
