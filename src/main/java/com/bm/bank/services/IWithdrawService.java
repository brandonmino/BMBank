package com.bm.bank.services;

import org.springframework.http.ResponseEntity;

//Withdraw Service Interface
public interface IWithdrawService {
    public ResponseEntity<Object> makeWithdraw(Long id, int amount);
}
