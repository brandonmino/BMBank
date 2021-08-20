package com.bm.bank.exceptions;

//Exception for when a user id is not found
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Could not find content with Id: " + id);
    }
}
