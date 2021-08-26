package com.bm.bank.services;

import java.net.URI;
import java.util.Optional;

import com.bm.bank.exceptions.ExcessiveWithdrawException;
import com.bm.bank.exceptions.UserIdNotProvidedException;
import com.bm.bank.exceptions.UserNotFoundException;
import com.bm.bank.models.Withdraw;
import com.bm.bank.models.WithdrawDTO;
import com.bm.bank.models.User;
import com.bm.bank.repos.IWithdrawRepo;
import com.bm.bank.repos.IUserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class WithdrawService implements IWithdrawService {
    @Autowired
    private IWithdrawRepo withdrawRepo;
    @Autowired
    private IUserRepo userRepo;

    private static final Logger logger = LoggerFactory.getLogger(WithdrawService.class);

    @Override
    public ResponseEntity<Object> makeWithdraw(Long userId, int amount) {
        logger.debug("Attempting to make a withdraw from acount with userId: " + userId + " and amount: " + amount);
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
                    withdrawRepo.save(withdraw);

                    WithdrawDTO responseObject = new WithdrawDTO("Successfully withdrew from account with id " + userId);
                    URI uri = linkTo(methodOn(WithdrawService.class).makeWithdraw(userId, amount)).withSelfRel().toUri();
                    ResponseEntity<Object> resultEntity = ResponseEntity.created(uri).body(responseObject);
                    logger.debug("HTTP Status: " + HttpStatus.OK.toString());
                    logger.debug("Withdraw from account with id: " + userId + " successful");
                    return resultEntity;
                }
            }
            else {
                throw new UserNotFoundException();
            }
        }
    }
}
