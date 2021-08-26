package com.bm.bank.services;

import com.bm.bank.models.WithdrawDTORequest;

import org.springframework.http.ResponseEntity;

//Withdraw Service Interface
public interface IWithdrawService {
    public ResponseEntity<Object> makeWithdraw(Long userId, WithdrawDTORequest request);
}
