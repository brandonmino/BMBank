package com.bm.bank.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Deposit Model
@Entity
@Table(name = "DepositTransactions")
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long transactionId;
    Long userId;
    int depositAmount;
    int initialBalance;
    int newBalance;

    public Deposit() {};

    public Long getTransactionId() {
        return transactionId;
    }

    public Long getUserId() {
        return userId;
    }

    public int getDepositAmount() {
        return depositAmount;
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

    public void setDepositAmount(int newAmount) {
        depositAmount = newAmount;
    }

    public void setInitialBalance(int newBalance) {
        initialBalance = newBalance;
    }

    public void setNewBalance(int balance) {
        newBalance = balance;
    }
}
