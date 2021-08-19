package com.bm.bank.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DepositTransactions")
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long transactionId;
    Long userId;
    int amount;

    public Deposit() {};

    public Long getTransactionId() {
        return transactionId;
    }

    public Long getUserId() {
        return userId;
    }

    public int getAmount() {
        return amount;
    }

    public void setTransactionId(Long newId) {
        transactionId = newId;
    }

    public void setUserId(Long newId) {
        userId = newId;
    }

    public void setAmount(int newAmount) {
        amount = newAmount;
    }
}
