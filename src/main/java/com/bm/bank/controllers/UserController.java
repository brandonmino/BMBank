package com.bm.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.bm.bank.models.UserRequestDTO;
import com.bm.bank.services.UserService;

//User controller object
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //Get an existing account given the user id. Returns code and message if succcessful or error if not.
    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> getId(@PathVariable(required=true) Long userId) {
        return userService.findById(userId);
    }

    //Create an account with given details. Returns code and message if succcessful or error if not.
    @PostMapping("/user/create")
    public ResponseEntity<Object> createUser(@RequestBody UserRequestDTO request) {
        return userService.createUser(request);
    }

    //Delete an account given the user id. Returns code and message if succcessful or error if not.
    @DeleteMapping("/user/delete/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable(required=true) Long userId) {
        return userService.delete(userId);
    }

}
