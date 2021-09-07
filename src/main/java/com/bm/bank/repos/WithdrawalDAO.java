package com.bm.bank.repos;

import java.util.Optional;

import com.bm.bank.models.Withdrawal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Withdraw Repo Interface
@Repository
public interface WithdrawalDAO extends CrudRepository<Withdrawal, Long> {
    public Optional<Withdrawal> findByUserId(Long userId);
    public Withdrawal save(Withdrawal withdraw);
}