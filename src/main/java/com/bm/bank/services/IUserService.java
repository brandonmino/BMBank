package com.bm.bank.services;

import com.bm.bank.models.User;

//Interface for user services
public interface IUserService {
    User findById(Long id);
    User createNewUser(User user);
    void delete(User user);
}
