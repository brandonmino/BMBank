package com.bm.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.bm.bank.models.User;
import com.bm.bank.services.UserService;

//import java.util.Map;

//User controller object
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //Get the existing account
    @GetMapping("/user/{id}")
    public User getId(@PathVariable(required=true) Long id) {
        return userService.findById(id);  
    }

    //Create an account with given details
    @PostMapping("/user/create")
    public EntityModel<User> createUser(@RequestBody User user) {
        User newUser = userService.createNewUser(user);
        return EntityModel.of(newUser,
                linkTo(methodOn(UserController.class).createUser(user)).withSelfRel()
        );   
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

    //Delete the given account
    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable(required=true) Long id) {
        User user = userService.findById(id);
        userService.delete(user);
        return "User with Id " + id + " was deleted";
    }
}
