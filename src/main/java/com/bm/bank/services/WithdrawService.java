package com.bm.bank.services;

import java.util.Optional;

import com.bm.bank.exceptions.ExcessiveWithdrawException;
import com.bm.bank.exceptions.UserIdNotProvidedException;
import com.bm.bank.exceptions.UserNotFoundException;
import com.bm.bank.models.Withdraw;
import com.bm.bank.models.User;
import com.bm.bank.repos.IWithdrawRepo;
import com.bm.bank.repos.IUserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawService implements IWithdrawService {
    @Autowired
    private IWithdrawRepo withdrawRepo;
    @Autowired
    private IUserRepo userRepo;

    @Override
    public Withdraw makeWithdraw(Long userId, int amount) {
        if (userId == null) {
            throw new UserIdNotProvidedException();
        }
        else {
            Optional<User> user = userRepo.findById(userId);
            if (user.isPresent()) {
                User withdrawUser = user.get();
                int newBalance = withdrawUser.getBalance() - amount;
                if (newBalance < 0) {
                    throw new ExcessiveWithdrawException();
                }
                else {
                    Withdraw withdraw = new Withdraw();
                    withdraw.setUserId(userId);
                    withdraw.setWithdrawAmount(amount);
                    withdraw.setInitialBalance(withdrawUser.getBalance());
                    withdraw.setNewBalance(newBalance);
                    withdrawUser.setBalance(newBalance);

                    userRepo.save(withdrawUser);
                    return withdrawRepo.save(withdraw);
                }
            }
            else {
                throw new UserNotFoundException(userId);
            }
        }
    }
}
