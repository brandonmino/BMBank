package com.bm.bank.services;

import org.springframework.http.ResponseEntity;

//Deposit Service Interface
public interface IDepositService {
    public ResponseEntity<Object> makeDeposit(Long id, int depositAmount);
}
