package com.bm.bank.exceptions;

//Exception for when a user id is not found
public class UserNotFoundException extends BMBankUserException {
    public UserNotFoundException() {
        super(1001, "Could not find content with given Id");
    }

    public UserNotFoundException(int code, String message) {
        super(code, message);
    }
}
