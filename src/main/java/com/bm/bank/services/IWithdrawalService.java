package com.bm.bank.services;

import com.bm.bank.models.WithdrawalDTORequest;

import org.springframework.http.ResponseEntity;

//Withdrawalal Service Interface
public interface IWithdrawalService {
    public ResponseEntity<Object> makeWithdrawal(Long userId, WithdrawalDTORequest request);
}
