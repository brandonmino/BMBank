package com.bm.bank.exceptions;

//Exception for when an invalid user was provided
public class UserNotProvidedException extends BMBankUserException {
    public UserNotProvidedException() {
        super(1002, "A user object with valid information was not provided");
    }

    public UserNotProvidedException(int code, String message) {
        super(code, message);
    }
}
