package com.bm.bank.repos;

import java.util.Optional;

import com.bm.bank.models.Deposit;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Deposit Repo Interface
@Repository
public interface DepositDAO extends CrudRepository<Deposit, Long> {
    public Optional<Deposit> findByUserId(Long userId);
    public Deposit save(Deposit deposit);
}