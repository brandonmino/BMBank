package com.bm.bank.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//User Object Model for interacting with database
@Entity
@Table(name = "User")
public class UserDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int balance;
    private String firstName;
    private String lastName;

    public UserDAO() {}

    public UserDAO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = 0;
    }

    public Long getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(Long newId) {
        id = newId;
    }

    public void setBalance(int newBalance) {
        balance = newBalance;
    }

    public void setFirstName(String newFirstName) {
        firstName = newFirstName;
    }

    public void setLastName(String newLastName) {
        lastName = newLastName;
    }
}