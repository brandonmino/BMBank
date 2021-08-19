package com.bm.bank.exceptions;

//User exception for when a user id is not found
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Could not find content with Id: " + id);
    }
}
