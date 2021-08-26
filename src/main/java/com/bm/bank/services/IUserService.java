package com.bm.bank.services;

import com.bm.bank.models.UserRequestDTO;

import org.springframework.http.ResponseEntity;

//User Service Interface
public interface IUserService {
    ResponseEntity<Object> findById(Long userId);
    ResponseEntity<Object> createUser(UserRequestDTO request);
    ResponseEntity<Object> delete(Long userId);
}
