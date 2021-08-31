package com.bm.bank.services;

import java.net.URI;
import java.util.Optional;

import com.bm.bank.exceptions.ExcessiveWithdrawalException;
import com.bm.bank.exceptions.NegativeWithdrawalException;
import com.bm.bank.exceptions.UserIdNotProvidedException;
import com.bm.bank.exceptions.UserNotFoundException;
import com.bm.bank.models.User;
import com.bm.bank.models.WithdrawalDTORequest;
import com.bm.bank.models.WithdrawalDTOResponse;
import com.bm.bank.models.Withdrawal;
import com.bm.bank.repos.UserDAO;
import com.bm.bank.repos.WithdrawalDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class WithdrawalService implements IWithdrawalService {
    @Autowired
    private WithdrawalDAO withdrawDAO;
    @Autowired
    private UserDAO userDAO;

    private static final Logger logger = LoggerFactory.getLogger(WithdrawalService.class);

    //Attempt to make the given withdrawal
    @Override
    public ResponseEntity<Object> makeWithdrawal(Long userId, WithdrawalDTORequest request) {
        int withdrawAmount = request.getWithdrawalAmount();
        logger.debug("Attempting to make a withdrawal from acount with userId: " + userId + " and amount: " + withdrawAmount);
        if (userId == null) {
            throw new UserIdNotProvidedException();
        }
        else {
            Optional<User> user = userDAO.findById(userId);
            if (user.isPresent()) {
                User withdrawUser = user.get();
                int newBalance = withdrawUser.getBalance() - withdrawAmount;
                if (newBalance < 0) {
                    throw new ExcessiveWithdrawalException();
                }
                else if (withdrawAmount < 0) {
                    throw new NegativeWithdrawalException();
                }
                else {
                    Withdrawal withdrawal = new Withdrawal();
                    withdrawal.setUserId(userId);
                    withdrawal.setWithdrawalAmount(withdrawAmount);
                    withdrawal.setInitialBalance(withdrawUser.getBalance());
                    withdrawal.setNewBalance(newBalance);
                    withdrawUser.setBalance(newBalance);

                    userDAO.save(withdrawUser);
                    withdrawDAO.save(withdrawal);

                    WithdrawalDTOResponse responseObject = new WithdrawalDTOResponse("Successfully made withdrawal of " + withdrawAmount + " from account with id " + userId);
                    URI uri = linkTo(methodOn(WithdrawalService.class).makeWithdrawal(userId, request)).withSelfRel().toUri();
                    ResponseEntity<Object> resultEntity = ResponseEntity.created(uri).body(responseObject);
                    logger.debug("HTTP Status: " + HttpStatus.OK.toString());
                    logger.debug("Withdrawalal from account with id: " + userId + " successful");
                    return resultEntity;
                }
            }
            else {
                throw new UserNotFoundException();
            }
        }
    }
}
