package com.bm.bank.services;

import java.util.Optional;

import com.bm.bank.exceptions.NegativeDepositException;
import com.bm.bank.exceptions.UserIdNotProvidedException;
import com.bm.bank.exceptions.UserNotFoundException;
import com.bm.bank.models.Deposit;
import com.bm.bank.models.User;
import com.bm.bank.repos.IDepositRepo;
import com.bm.bank.repos.IUserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//Deposit Service
@Service
public class DepositService implements IDepositService {
    @Autowired
    private IDepositRepo depositRepo;
    @Autowired
    private IUserRepo userRepo;

    private static final Logger logger = LoggerFactory.getLogger(DepositService.class);

    //Method for making a deposit
    @Override
    public Deposit makeDeposit(Long userId, int depositAmount) {
        logger.info("Attempting to make deposit with the following info: userID: " + userId + " depositAmount: " + depositAmount);
        if (userId == null) {
            throw new UserIdNotProvidedException();
        }
        else if (depositAmount < 0) {
            throw new NegativeDepositException();
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
                Deposit newDeposit = depositRepo.save(deposit);
                logger.info("HTTP Status: " + HttpStatus.CREATED.toString());
                logger.info(newDeposit.toString());
                return newDeposit;
            }
            else {
                throw new UserNotFoundException(userId);
            }
        }
    }
}
