package com.bm.bank.exceptions;

//Exception for when an invalid user was provided
public class UserNotProvidedException extends RuntimeException{
    public UserNotProvidedException() {
        super("A user object with valid information was not provided");
    }
}
