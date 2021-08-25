package com.bm.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.bm.bank.models.User;
import com.bm.bank.services.UserService;

//User controller object
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //Get the existing account
    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getId(@PathVariable(required=true) Long id) {
        return userService.findById(id);
    }

    //Create an account with given details
    @PostMapping("/user/create")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        return userService.createNewUser(user);
    }

    //Delete the given account
    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(required=true) Long id) {
        return userService.delete(id);
    }

}
