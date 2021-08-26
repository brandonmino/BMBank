package com.bm.bank.exceptions;

//Exception for when user id is not provided
public class UserIdNotProvidedException extends BMBankUserException {
    public UserIdNotProvidedException() {
        super(1000, "No Id was provided in the search");
    }

    public UserIdNotProvidedException(int code, String message) {
        super(code, message);
    }
}
