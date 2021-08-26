package com.bm.bank.services;

import java.net.URI;
import java.util.Optional;

import com.bm.bank.exceptions.UserIdNotProvidedException;
import com.bm.bank.exceptions.UserNotFoundException;
import com.bm.bank.exceptions.UserNotProvidedException;
import com.bm.bank.models.User;
import com.bm.bank.models.UserRequestDTO;
import com.bm.bank.models.UserResponseDTO;
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

    //Find a given user from the database given their id
    @Override
    public ResponseEntity<Object> findById(UserRequestDTO request) {
        Long userId = request.getId();
        logger.debug("Attempting to retrieve user with the following id: " + userId);
        if (userId == null) {
            throw new UserIdNotProvidedException();
        }
        else {
            Optional<User> user = userRepo.findById(request.getId());
            if (user.isPresent()) {
                User retrievedUser = user.get();

                UserResponseDTO responseObject = new UserResponseDTO(retrievedUser, "Successfully retrieved user with id " + userId);
                ResponseEntity<Object> resultEntity = ResponseEntity.ok().body(responseObject);
                logger.debug("HTTP Status: " + HttpStatus.OK.toString());
                logger.debug("Successfully retrieved user with id: " + userId + ". Info: " + retrievedUser);
                return resultEntity;
            }
            else {
                throw new UserNotFoundException();
            }
        }
    }

    //Save the given user to the database given the user's details
    @Override
    public ResponseEntity<Object> createUser(UserRequestDTO request) {
        logger.debug("Attempting to create user with the following info: " + request);
        if (request == null) {
            throw new UserNotProvidedException();
        }
        else {
            User newUser = new User();
            newUser.setBalance(0);
            newUser.setFirstName(request.getFirstName());
            newUser.setLastName(request.getLastName());
            userRepo.save(newUser);

            UserResponseDTO responseObject = new UserResponseDTO("Successfully created user with id " + newUser.getId());
            URI uri = linkTo(methodOn(UserService.class).createUser(request)).withSelfRel().toUri();
            ResponseEntity<Object> resultEntity = ResponseEntity.created(uri).body(responseObject);
            logger.debug("HTTP Status: " + HttpStatus.CREATED.toString());
            logger.debug("Successfully created new user: " + newUser);
            return resultEntity;
        }
    }

    //Delete a given user from the database given their id
    @Override
    public ResponseEntity<Object> delete(UserRequestDTO request) {
        Long userId = request.getId();
        logger.debug("Attempting to delete user with the following id: " + userId);
        if (userId == null) {
            throw new UserNotProvidedException();
        }
        else {
            Optional<User> user = userRepo.findById(userId);
            if (user.isPresent()) {
                userRepo.delete(user.get());
                UserResponseDTO responseObject = new UserResponseDTO("Successfully deleted user with id " + userId);
                ResponseEntity<Object> resultEntity = ResponseEntity.ok().body(responseObject);
                logger.debug("HTTP Status: " + HttpStatus.OK.toString());
                logger.debug("Status: user with id: " + userId + " deleted");
                return resultEntity;
            }
            else {
                throw new UserNotFoundException();
            }
        }
    }
}
