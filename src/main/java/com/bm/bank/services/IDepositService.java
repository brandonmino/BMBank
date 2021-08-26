package com.bm.bank.services;

import com.bm.bank.models.DepositRequestDTO;

import org.springframework.http.ResponseEntity;

//Deposit Service Interface
public interface IDepositService {
    public ResponseEntity<Object> makeDeposit(Long userId, DepositRequestDTO request);
}
