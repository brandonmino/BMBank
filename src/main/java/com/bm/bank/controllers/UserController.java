package com.bm.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;

import com.bm.bank.exceptions.UserIdNotProvidedException;
import com.bm.bank.exceptions.UserNotFoundException;
import com.bm.bank.exceptions.UserNotProvidedException;
import com.bm.bank.models.User;
import com.bm.bank.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import java.util.Map;

//User controller object
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    //Get the existing account
    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getId(@PathVariable(required=true) Long id) {
        logger.info("Attempting to retrieve user with the following info: userID: " + id);
        try {
            User retrievedUser = userService.findById(id);
            ResponseEntity<Object> resultEntity = ResponseEntity.ok().body(retrievedUser);
            logger.info("HTTP Status: " + HttpStatus.OK.toString());
            logger.info("Successfully retrieved user with id: " + id + ". Info: " + retrievedUser);
            return resultEntity;
            //return ResponseEntity.created(uri).body(retrievedUser);
        }
        catch (UserNotFoundException ex) {
            logger.warn("HTTP Status: " + HttpStatus.METHOD_NOT_ALLOWED.toString());
            logger.warn(ex.toString());
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        }   
        catch (UserIdNotProvidedException ex) {
            logger.warn("HTTP Status: " + HttpStatus.BAD_REQUEST.toString());
            logger.warn(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }  
    }

    //Create an account with given details
    @PostMapping("/user/create")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        logger.info("Attempting to create user with the following info: " + user);
        try {
            User newUser = userService.createNewUser(user);
            URI uri = linkTo(methodOn(UserController.class).createUser(newUser)).withSelfRel().toUri();
            ResponseEntity<Object> resultEntity = ResponseEntity.created(uri).body(newUser);
            logger.info("HTTP Status: " + HttpStatus.CREATED.toString());
            logger.info("Successfully created new user: " + newUser);
            return resultEntity;
        }
        catch (UserNotProvidedException ex) {
            logger.warn("HTTP Status: " + HttpStatus.METHOD_NOT_ALLOWED.toString());
            logger.warn(ex.toString());
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        }
    }

    //Delete the given account
    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(required=true) Long id) {
        logger.info("Attempting to delete user with the following id: " + id);
        try {
            userService.delete(id);
            ResponseEntity<Object> resultEntity = ResponseEntity.ok().body("Status: user with id " + id + " deleted");
            logger.info("HTTP Status: " + HttpStatus.OK.toString());
            logger.info("Status: user with id: " + id + " deleted");
            return resultEntity;
        }
        catch (UserNotFoundException ex) {
            logger.warn("HTTP Status: " + HttpStatus.METHOD_NOT_ALLOWED.toString());
            logger.warn(ex.toString());
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        }   
        catch (UserNotProvidedException ex) {
            logger.warn("HTTP Status: " + HttpStatus.BAD_REQUEST.toString());
            logger.warn(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // //Update given field(s) with new values
    // @PatchMapping("/user/update/{id}")
    // public String updateUser(@RequestBody Map<String, Object> fields, @PathVariable(required=true) Long id) {
    //     User user = userService.findById(id);
    //     fields.forEach((key, value) -> {
    //         //SOS
    //     });
    //     userService.save(user);
    //     return "User with Id " + id + " was deleted";
    // }

}
