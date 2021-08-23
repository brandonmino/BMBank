package com.bm.bank.services;

import java.util.Optional;

import com.bm.bank.exceptions.UserIdNotProvidedException;
import com.bm.bank.exceptions.UserNotFoundException;
import com.bm.bank.exceptions.UserNotProvidedException;
import com.bm.bank.models.User;
import com.bm.bank.repos.IUserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//User services for interacting with repo and returning info to controller
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepo userRepo;

    public UserService() {}

    @Override
    public User findById(Long id) {
        if (id == null) {
            throw new UserIdNotProvidedException();
        }
        else {
            Optional<User> user = userRepo.findById(id);
            if (user.isPresent()) {
                return user.get();
            }
            else {
                throw new UserNotFoundException(id);
            }
        }
    }

    //Save the given user to the database
    @Override
    public User createNewUser(User user) {
        if (user == null) {
            throw new UserNotProvidedException();
        }
        else {
            User newUser = new User();
            newUser.setId(user.getId());
            newUser.setBalance(0);
            newUser.setFirstName(user.getFirstName());
            newUser.setLastName(user.getLastName());
            return userRepo.save(user);
        }
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new UserNotProvidedException();
        }
        else {
            Optional<User> user = userRepo.findById(id);
            if (user.isPresent()) {
                userRepo.delete(user.get());
            }
            else {
                throw new UserNotFoundException(id);
            }
        }
    }
}
