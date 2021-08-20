package com.bm.bank.services;

import com.bm.bank.models.Withdraw;

public interface IWithdrawService {
    public Withdraw makeWithdraw(Long id, int amount);
}
