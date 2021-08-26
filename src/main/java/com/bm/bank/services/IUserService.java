package com.bm.bank.services;

import com.bm.bank.models.UserRequestDTO;

import org.springframework.http.ResponseEntity;

//User Service Interface
public interface IUserService {
    ResponseEntity<Object> findById(UserRequestDTO request);
    ResponseEntity<Object> createUser(UserRequestDTO request);
    ResponseEntity<Object> delete(UserRequestDTO request);
}
