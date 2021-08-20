package com.bm.bank.services;

import com.bm.bank.models.Deposit;

public interface IDepositService {
    public Deposit makeDeposit(Long id, int depositAmount);
}
