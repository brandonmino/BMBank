package com.bm.bank.exceptions;

public class UserNotProvidedException extends RuntimeException{
    public UserNotProvidedException() {
        super("A valid user configuration was not provided");
    }
}
