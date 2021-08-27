package com.bm.bank.repos;

import java.util.Optional;

import com.bm.bank.models.Withdraw;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Withdraw Repo Interface
@Repository
public interface WithdrawDAO extends CrudRepository<Withdraw, Long> {
    public Optional<Withdraw> findByUserId(Long userId);
    public Withdraw save(Withdraw withdraw);
}