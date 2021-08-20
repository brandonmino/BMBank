package com.bm.bank.repos;

import java.util.Optional;

import com.bm.bank.models.Deposit;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepositRepo extends CrudRepository<Deposit, Long> {
    public Optional<Deposit> findByUserId(Long userId);
    public Deposit save(Deposit deposit);
}