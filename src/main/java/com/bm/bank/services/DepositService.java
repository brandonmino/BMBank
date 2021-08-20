package com.bm.bank.services;

import java.util.Optional;

import com.bm.bank.exceptions.UserIdNotProvidedException;
import com.bm.bank.exceptions.UserNotFoundException;
import com.bm.bank.models.Deposit;
import com.bm.bank.models.User;
import com.bm.bank.repos.IDepositRepo;
import com.bm.bank.repos.IUserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositService implements IDepositService {
    @Autowired
    private IDepositRepo depositRepo;
    @Autowired
    private IUserRepo userRepo;

    @Override
    public Deposit makeDeposit(Long userId, int depositAmount) {
        if (userId == null) {
            throw new UserIdNotProvidedException();
        }
        else {
            Optional<User> user = userRepo.findById(userId);
            if (user.isPresent()) {
                User depositUser = user.get();
                int newBalance = depositUser.getBalance() + depositAmount;
                Deposit deposit = new Deposit();
                deposit.setUserId(userId);
                deposit.setDepositAmount(depositAmount);
                deposit.setInitialBalance(depositUser.getBalance());
                deposit.setNewBalance(newBalance);
                depositUser.setBalance(newBalance);

                userRepo.save(depositUser);
                return depositRepo.save(deposit);
            }
            else {
                throw new UserNotFoundException(userId);
            }
        }
    }
}
