package com.bm.bank.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Withdraw Object Model for interacting with database
@Entity
@Table(name = "Withdraw")
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Deposit{");
        sb.append("transactionId=").append(transactionId);
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", withdrawAmount=").append(withdrawAmount).append('\'');
        sb.append(", initialBalance=").append(initialBalance).append('\'');
        sb.append(", newBalance=").append(newBalance);
        sb.append('}');
        return sb.toString();
    }
}
