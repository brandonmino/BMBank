package com.bm.bank.services;

import java.net.URI;
import java.util.Optional;

import com.bm.bank.exceptions.UserIdNotProvidedException;
import com.bm.bank.exceptions.UserNotFoundException;
import com.bm.bank.exceptions.UserNotProvidedException;
import com.bm.bank.models.User;
import com.bm.bank.repos.IUserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//User services for interacting with repo and returning info to controller
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepo userRepo;

    final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService() {}

    @Override
    public ResponseEntity<Object> findById(Long id) {
        logger.debug("Attempting to retrieve user with the following id: " + id);
        if (id == null) {
            throw new UserIdNotProvidedException();
        }
        else {
            Optional<User> user = userRepo.findById(id);
            if (user.isPresent()) {
                User retrievedUser = user.get();
                ResponseEntity<Object> resultEntity = ResponseEntity.ok().body(retrievedUser);
                logger.debug("HTTP Status: " + HttpStatus.OK.toString());
                logger.debug("Successfully retrieved user with id: " + id + ". Info: " + retrievedUser);
                return resultEntity;
            }
            else {
                throw new UserNotFoundException();
            }
        }
    }

    //Save the given user to the database
    @Override
    public ResponseEntity<Object> createNewUser(User user) {
        logger.debug("Attempting to create user with the following info: " + user);
        if (user == null) {
            throw new UserNotProvidedException();
        }
        else {
            User newUser = new User();
            newUser.setId(user.getId());
            newUser.setBalance(0);
            newUser.setFirstName(user.getFirstName());
            newUser.setLastName(user.getLastName());
            User resultUser = userRepo.save(user);
            URI uri = linkTo(methodOn(UserService.class).createNewUser(resultUser)).withSelfRel().toUri();
            ResponseEntity<Object> resultEntity = ResponseEntity.created(uri).body(resultUser);
            logger.debug("HTTP Status: " + HttpStatus.CREATED.toString());
            logger.debug("Successfully created new user: " + newUser);
            return resultEntity;
        }
    }

    @Override
    public ResponseEntity<Object> delete(Long id) {
        logger.debug("Attempting to delete user with the following id: " + id);
        if (id == null) {
            throw new UserNotProvidedException();
        }
        else {
            Optional<User> user = userRepo.findById(id);
            if (user.isPresent()) {
                userRepo.delete(user.get());
                ResponseEntity<Object> resultEntity = ResponseEntity.ok().body("Status: user with id " + id + " deleted");
                logger.debug("HTTP Status: " + HttpStatus.OK.toString());
                logger.debug("Status: user with id: " + id + " deleted");
                return resultEntity;
            }
            else {
                throw new UserNotFoundException();
            }
        }
    }
}
