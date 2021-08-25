package com.bm.bank.services;

import com.bm.bank.models.User;

import org.springframework.http.ResponseEntity;

//User Service Interface
public interface IUserService {
    ResponseEntity<Object> findById(Long id);
    ResponseEntity<Object> createNewUser(User user);
    ResponseEntity<Object> delete(Long id);
}
