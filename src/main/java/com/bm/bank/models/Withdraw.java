package com.bm.bank.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WithdrawTransactions")
public class Withdraw {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long transactionId;
    Long userId;
    int withdrawAmount;
    int initialBalance;
    int newBalance;

    public Withdraw() {};

    public Long getTransactionId() {
        return transactionId;
    }

    public Long getUserId() {
        return userId;
    }

    public int getWithdrawAmount() {
        return withdrawAmount;
    }

    public int getInitialBalance() {
        return initialBalance;
    }

    public int getNewBalance() {
        return newBalance;
    }

    public void setTransactionId(Long newId) {
        transactionId = newId;
    }

    public void setUserId(Long newId) {
        userId = newId;
    }

    public void setWithdrawAmount(int newAmount) {
        withdrawAmount = newAmount;
    }

    public void setInitialBalance(int newBalance) {
        initialBalance = newBalance;
    }

    public void setNewBalance(int balance) {
        newBalance = balance;
    }
}
