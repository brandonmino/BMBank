package com.bm.bank.services;

import com.bm.bank.models.Deposit;

//Deposit Service Interface
public interface IDepositService {
    public Deposit makeDeposit(Long id, int depositAmount);
}
