package com.bm.bank.exceptions;

//Exception for when user id is not provided
public class UserIdNotProvidedException extends RuntimeException {
    public UserIdNotProvidedException() {
        super("No Id was provided in the search");
    }
}
