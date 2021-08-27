package com.bm.bank.services;

import java.net.URI;
import java.util.Optional;

import com.bm.bank.exceptions.ExcessiveWithdrawException;
import com.bm.bank.exceptions.NegativeWithdrawException;
import com.bm.bank.exceptions.UserIdNotProvidedException;
import com.bm.bank.exceptions.UserNotFoundException;
import com.bm.bank.models.Withdraw;
import com.bm.bank.models.WithdrawDTORequest;
import com.bm.bank.models.WithdrawDTOResponse;
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

    //Attempt to make the given withdraw
    @Override
    public ResponseEntity<Object> makeWithdraw(Long userId, WithdrawDTORequest request) {
        int withdrawAmount = request.getWithdrawAmount();
        logger.debug("Attempting to make a withdraw from acount with userId: " + userId + " and amount: " + withdrawAmount);
        if (userId == null) {
            throw new UserIdNotProvidedException();
        }
        else {
            Optional<User> user = userRepo.findById(userId);
            if (user.isPresent()) {
                User withdrawUser = user.get();
                int newBalance = withdrawUser.getBalance() - withdrawAmount;
                if (newBalance < 0) {
                    throw new ExcessiveWithdrawException();
                }
                else if (withdrawAmount < 0) {
                    throw new NegativeWithdrawException();
                }
                else {
                    Withdraw withdraw = new Withdraw();
                    withdraw.setUserId(userId);
                    withdraw.setWithdrawAmount(withdrawAmount);
                    withdraw.setInitialBalance(withdrawUser.getBalance());
                    withdraw.setNewBalance(newBalance);
                    withdrawUser.setBalance(newBalance);
                    userRepo.save(withdrawUser);
                    withdrawRepo.save(withdraw);

                    WithdrawDTOResponse responseObject = new WithdrawDTOResponse("Successfully made withdraw of " + withdrawAmount + " from account with id " + userId);
                    URI uri = linkTo(methodOn(WithdrawService.class).makeWithdraw(userId, request)).withSelfRel().toUri();
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
