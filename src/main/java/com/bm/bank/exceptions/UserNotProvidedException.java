package com.bm.bank.exceptions;

//Exception for when an invalid user was provided
public class UserNotProvidedException extends RuntimeException{
    public UserNotProvidedException() {
        super("A valid user configuration was not provided");
    }
}
